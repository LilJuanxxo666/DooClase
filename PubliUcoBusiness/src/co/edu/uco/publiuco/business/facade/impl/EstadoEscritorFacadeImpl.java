package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoEscritorAssembler;
import co.edu.uco.publiuco.business.business.EstadoEscritorBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoEscritorBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoEscritorFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoEscritorDTO;

public final class EstadoEscritorFacadeImpl implements EstadoEscritorFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoEscritorBusiness business;

	public EstadoEscritorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoEscritorBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoEscritorDTO> list(final EstadoEscritorDTO dto) {
		try {
			final var domain = EstadoEscritorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoEscritorAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoEscritorFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoEscritorFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
