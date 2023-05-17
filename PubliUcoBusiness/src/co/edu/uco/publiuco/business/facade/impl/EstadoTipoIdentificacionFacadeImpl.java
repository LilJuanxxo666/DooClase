package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoIdentificacionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoIdentificacionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoTipoIdentificacionBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoTipoIdentificacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoIdentificacionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoTipoIdentificacionDTO;

public final class EstadoTipoIdentificacionFacadeImpl implements EstadoTipoIdentificacionFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoTipoIdentificacionBusiness business;

	public EstadoTipoIdentificacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoTipoIdentificacionBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoTipoIdentificacionDTO> list(final EstadoTipoIdentificacionDTO dto) {
		try {
			final var domain = EstadoTipoIdentificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoTipoIdentificacionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoTipoIdentificacionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoTipoIdentificacionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
