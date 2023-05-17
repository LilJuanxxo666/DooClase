package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoComentarioLectorAssembler;
import co.edu.uco.publiuco.business.business.EstadoComentarioLectorBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoComentarioLectorBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoComentarioLectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoComentarioLectorFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoComentarioLectorDTO;

public final class EstadoComentarioLectorFacadeImpl implements EstadoComentarioLectorFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoComentarioLectorBusiness business;

	public EstadoComentarioLectorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoComentarioLectorBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoComentarioLectorDTO> list(final EstadoComentarioLectorDTO dto) {
		try {
			final var domain = EstadoComentarioLectorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoComentarioLectorAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoComentarioLectorFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoComentarioLectorFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
