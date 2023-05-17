package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.SuscripcionCategoriaAssembler;
import co.edu.uco.publiuco.business.business.SuscripcionCategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.SuscripcionCategoriaBusinessImpl;
import co.edu.uco.publiuco.business.facade.SuscripcionCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.SuscripcionCategoriaFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.SuscripcionCategoriaDTO;

public final class SuscripcionCategoriaFacadeImpl implements SuscripcionCategoriaFacade{
	
	private final DAOFactory daoFactory;
	private final SuscripcionCategoriaBusiness business;

	public SuscripcionCategoriaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new SuscripcionCategoriaBusinessImpl(daoFactory);
	}

	@Override
	public void register(final SuscripcionCategoriaDTO dto) {
		try {
			final var domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.register(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = SuscripcionCategoriaFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = SuscripcionCategoriaFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<SuscripcionCategoriaDTO> list(final SuscripcionCategoriaDTO dto) {
		try {
			final var domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return SuscripcionCategoriaAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = SuscripcionCategoriaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = SuscripcionCategoriaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modify(final SuscripcionCategoriaDTO dto) {
		try {
			final var domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.modify(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = SuscripcionCategoriaFacadeImplMessages.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = SuscripcionCategoriaFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void drop(final SuscripcionCategoriaDTO dto) {
		try {
			final var domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.drop(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = SuscripcionCategoriaFacadeImplMessages.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = SuscripcionCategoriaFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
