package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;


import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoTipoRelacionInstitucionBusinessIml;
import co.edu.uco.publiuco.business.facade.EstadoTipoRelacionInstitucionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public final class EstadoTipoRelacionInstitucionFacadeImpl implements EstadoTipoRelacionInstitucionFacade {

	private final DAOFactory daoFactory;
	private final EstadoTipoRelacionInstitucionBusiness business;

	public EstadoTipoRelacionInstitucionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoTipoRelacionInstitucionBusinessIml(daoFactory);
	}

	@Override
	public void register(final EstadoTipoRelacionInstitucionDTO dto) {
		try {
			final var domain = EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.register(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = EstadoTipoRelacionInstitucionFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoTipoRelacionInstitucionFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<EstadoTipoRelacionInstitucionDTO> list(EstadoTipoRelacionInstitucionDTO dto) {
		try {
			final var domain = EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoTipoRelacionInstitucionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modify(EstadoTipoRelacionInstitucionDTO dto) {
		try {
			final var domain = EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.modify(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = "";
			var technicalMessage = "";

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void drop(EstadoTipoRelacionInstitucionDTO dto) {
		try {
			final var domain = EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.drop(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = "";
			var technicalMessage = "";

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
