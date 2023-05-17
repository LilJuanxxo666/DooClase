package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.RespuestaAssembler;
import co.edu.uco.publiuco.business.business.RespuestaBusiness;
import co.edu.uco.publiuco.business.business.impl.RespuestaBusinessImpl;
import co.edu.uco.publiuco.business.facade.RespuestaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.RespuestaFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RespuestaDTO;

public final class RespuestaFacadeImpl implements RespuestaFacade{
	
	private final DAOFactory daoFactory;
	private final RespuestaBusiness business;

	public RespuestaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new RespuestaBusinessImpl(daoFactory);
	}
	
	@Override
	public List<RespuestaDTO> list(final RespuestaDTO dto) {
		try {
			final var domain = RespuestaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return RespuestaAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = RespuestaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = RespuestaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
