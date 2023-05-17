package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoAccesoAssembler;
import co.edu.uco.publiuco.business.business.TipoAccesoBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoAccesoBusinessImpl;
import co.edu.uco.publiuco.business.facade.TipoAccesoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.TipoAccesoFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;

public final class TipoAccesoFacadeImpl implements TipoAccesoFacade{
	
	private final DAOFactory daoFactory;
	private final TipoAccesoBusiness business;

	
	public TipoAccesoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new TipoAccesoBusinessImpl(daoFactory);
	}
	
	@Override
	public List<TipoAccesoDTO> list(final TipoAccesoDTO dto) {
		try {
			final var domain = TipoAccesoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return TipoAccesoAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = TipoAccesoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoAccesoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
