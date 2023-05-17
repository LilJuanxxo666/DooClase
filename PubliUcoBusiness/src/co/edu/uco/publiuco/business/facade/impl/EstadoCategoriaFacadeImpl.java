package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoCategoriaAssembler;
import co.edu.uco.publiuco.business.business.EstadoCategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoCategoriaBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoCategoriaFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoCategoriaDTO;

public final class EstadoCategoriaFacadeImpl implements EstadoCategoriaFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoCategoriaBusiness business;

	public EstadoCategoriaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoCategoriaBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoCategoriaDTO> list(final EstadoCategoriaDTO dto) {
		try {
			final var domain = EstadoCategoriaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoCategoriaAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoCategoriaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoCategoriaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
