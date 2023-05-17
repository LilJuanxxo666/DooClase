package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.LectorAssembler;
import co.edu.uco.publiuco.business.business.LectorBusiness;
import co.edu.uco.publiuco.business.business.impl.LectorBusinessImpl;
import co.edu.uco.publiuco.business.facade.LectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.LectorFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.LectorDTO;

public final class LectorFacadeImpl implements LectorFacade{
	
	private final DAOFactory daoFactory;
	private final LectorBusiness business;

	public LectorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new LectorBusinessImpl(daoFactory);
	}

	@Override
	public void register(final LectorDTO dto) {
		try {
			final var domain = LectorAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.register(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = LectorFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = LectorFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<LectorDTO> list(final LectorDTO dto) {
		try {
			final var domain = LectorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return LectorAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = LectorFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = LectorFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modify(final LectorDTO dto) {
		try {
			final var domain = LectorAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.modify(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = LectorFacadeImplMessages.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = LectorFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void drop(final LectorDTO dto) {
		try {
			final var domain = LectorAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.drop(domain);
			daoFactory.confirmarTransaccion();

		} catch (PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daoFactory.cancelarTransaccion();

			var userMessage = LectorFacadeImplMessages.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = LectorFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
