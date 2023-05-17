package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoObservacionRevisorAssembler;
import co.edu.uco.publiuco.business.business.EstadoObservacionRevisorBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoObservacionRevisorBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoObservacionRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoObservacionRevisorFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoObservacionRevisorDTO;

public final class EstadoObservacionRevisorFacadeImpl implements EstadoObservacionRevisorFacade{

	private final DAOFactory daoFactory;
	private final EstadoObservacionRevisorBusiness business;

	public EstadoObservacionRevisorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoObservacionRevisorBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoObservacionRevisorDTO> list(final EstadoObservacionRevisorDTO dto) {
		try {
			final var domain = EstadoObservacionRevisorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoObservacionRevisorAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoObservacionRevisorFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoObservacionRevisorFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
