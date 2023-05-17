package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;
import co.edu.uco.publiuco.business.assembler.concrete.EstadoRevisionAssembler;
import co.edu.uco.publiuco.business.business.EstadoRevisionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoRevisionBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoRevisionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoRevisionDTO;

public final class EstadoRevisionFacadeImpl implements EstadoRevisionFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoRevisionBusiness business;

	public EstadoRevisionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoRevisionBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoRevisionDTO> list(final EstadoRevisionDTO dto) {
		try {
			final var domain = EstadoRevisionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoRevisionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoRevisionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoRevisionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
