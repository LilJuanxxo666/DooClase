package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoEscritorAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoEscritorBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoTipoEscritorBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoTipoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoEscritorFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoTipoEscritorDTO;

public final class EstadoTipoEscritorFacadeImpl implements EstadoTipoEscritorFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoTipoEscritorBusiness business;

	public EstadoTipoEscritorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoTipoEscritorBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoTipoEscritorDTO> list(final EstadoTipoEscritorDTO dto) {
		try {
			final var domain = EstadoTipoEscritorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoTipoEscritorAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoTipoEscritorFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoTipoEscritorFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
}
