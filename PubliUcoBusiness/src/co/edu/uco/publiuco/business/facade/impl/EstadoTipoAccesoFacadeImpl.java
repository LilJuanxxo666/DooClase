package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoAccesoAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoAccesoBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoTipoAccesoBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoTipoAccesoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoAccesoFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoTipoAccesoDTO;

public final class EstadoTipoAccesoFacadeImpl implements EstadoTipoAccesoFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoTipoAccesoBusiness business;

	public EstadoTipoAccesoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoTipoAccesoBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoTipoAccesoDTO> list(final EstadoTipoAccesoDTO dto) {
		try {
			final var domain = EstadoTipoAccesoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoTipoAccesoAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoTipoAccesoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoTipoAccesoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
