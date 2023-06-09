package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoPlanAssembler;
import co.edu.uco.publiuco.business.business.EstadoPlanBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoPlanBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoPlanFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoPlanFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoPlanDTO;

public final class EstadoPlanFacadeImpl implements EstadoPlanFacade{

	private final DAOFactory daoFactory;
	private final EstadoPlanBusiness business;

	public EstadoPlanFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoPlanBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoPlanDTO> list(final EstadoPlanDTO dto) {
		try {
			final var domain = EstadoPlanAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoPlanAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoPlanFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoPlanFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
