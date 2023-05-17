package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoRevisionAssembler;
import co.edu.uco.publiuco.business.business.TipoRevisionBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoRevisionBusinessImpl;
import co.edu.uco.publiuco.business.facade.TipoRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.TipoRevisionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoRevisionDTO;

public final class TipoRevisionFacadeImpl implements TipoRevisionFacade{
	
	private final DAOFactory daoFactory;
	private final TipoRevisionBusiness business;

	public TipoRevisionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new TipoRevisionBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoRevisionDTO> list(final TipoRevisionDTO dto) {
		try {
			final var domain = TipoRevisionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return TipoRevisionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = TipoRevisionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoRevisionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
