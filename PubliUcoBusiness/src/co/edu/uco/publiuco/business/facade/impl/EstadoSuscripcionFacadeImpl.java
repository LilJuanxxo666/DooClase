package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoSuscripcionAssembler;
import co.edu.uco.publiuco.business.business.EstadoSuscripcionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoSuscripcionBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoSuscripcionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoSuscripcionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoSuscripcionDTO;

public final class EstadoSuscripcionFacadeImpl implements EstadoSuscripcionFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoSuscripcionBusiness business;

	public EstadoSuscripcionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoSuscripcionBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoSuscripcionDTO> list(final EstadoSuscripcionDTO dto) {
		try {
			final var domain = EstadoSuscripcionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoSuscripcionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoSuscripcionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoSuscripcionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
