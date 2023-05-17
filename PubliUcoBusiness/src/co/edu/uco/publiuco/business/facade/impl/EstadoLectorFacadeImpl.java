package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoLectorAssembler;
import co.edu.uco.publiuco.business.business.EstadoLectorBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoLectorBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoLectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoLectorFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoLectorDTO;

public final class EstadoLectorFacadeImpl implements EstadoLectorFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoLectorBusiness business;

	public EstadoLectorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoLectorBusinessImpl(daoFactory);
	}
	
	@Override
	public List<EstadoLectorDTO> list(final EstadoLectorDTO dto) {
		try {
			final var domain = EstadoLectorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoLectorAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoLectorFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoLectorFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
