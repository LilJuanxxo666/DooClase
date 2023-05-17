package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoEscritorAssembler;
import co.edu.uco.publiuco.business.business.TipoEscritorBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoEscritorBusinessImpl;
import co.edu.uco.publiuco.business.facade.TipoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.TipoEscritorFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoEscritorDTO;

public final class TipoEscritorFacadeImpl implements TipoEscritorFacade{
	
	private final DAOFactory daoFactory;
	private final TipoEscritorBusiness business;

	public TipoEscritorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new TipoEscritorBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoEscritorDTO> list(final TipoEscritorDTO dto) {
		try {
			final var domain = TipoEscritorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return TipoEscritorAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = TipoEscritorFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoEscritorFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
