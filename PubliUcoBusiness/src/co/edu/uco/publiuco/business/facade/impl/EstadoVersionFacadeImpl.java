package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoVersionAssembler;
import co.edu.uco.publiuco.business.business.EstadoVersionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoVersionBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoVersionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoVersionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoVersionDTO;

public final class EstadoVersionFacadeImpl implements EstadoVersionFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoVersionBusiness business;

	public EstadoVersionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new EstadoVersionBusinessImpl(daoFactory);
	}

	@Override
	public List<EstadoVersionDTO> list(final EstadoVersionDTO dto) {
		try {
			final var domain = EstadoVersionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return EstadoVersionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = EstadoVersionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoVersionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
