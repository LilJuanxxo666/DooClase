package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoAdministradorCategoriaAssembler;
import co.edu.uco.publiuco.business.business.EstadoAdministradorCategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoAdministradorCategoriaBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoAdministradorCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoAdministradorCategoriaFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoAdministradorCategoriaDTO;

public final class EstadoAdministradorCategoriaFacadeImpl implements EstadoAdministradorCategoriaFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoAdministradorCategoriaBusiness business;

	public EstadoAdministradorCategoriaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoAdministradorCategoriaBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoAdministradorCategoriaDTO> list(final EstadoAdministradorCategoriaDTO dto) {
		try {
			final var domain = EstadoAdministradorCategoriaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoAdministradorCategoriaAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoAdministradorCategoriaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoAdministradorCategoriaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
