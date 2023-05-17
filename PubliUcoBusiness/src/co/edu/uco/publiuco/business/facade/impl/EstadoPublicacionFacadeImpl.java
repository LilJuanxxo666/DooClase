package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoPublicacionAssembler;
import co.edu.uco.publiuco.business.business.EstadoPublicacionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoPublicacionBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoPublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoPublicacionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoPublicacionDTO;

public final class EstadoPublicacionFacadeImpl implements EstadoPublicacionFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoPublicacionBusiness business;

	public EstadoPublicacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoPublicacionBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoPublicacionDTO> list(final EstadoPublicacionDTO dto) {
		try {
			final var domain = EstadoPublicacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoPublicacionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoPublicacionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoPublicacionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
