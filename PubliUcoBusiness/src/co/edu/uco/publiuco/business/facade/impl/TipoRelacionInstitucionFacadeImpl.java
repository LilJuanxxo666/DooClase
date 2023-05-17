package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.TipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoRelacionInstitucionBusinessImpl;
import co.edu.uco.publiuco.business.facade.TipoRelacionInstitucionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.TipoRelacionInstitucionFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;

public final class TipoRelacionInstitucionFacadeImpl implements TipoRelacionInstitucionFacade{

	private final DAOFactory daoFactory;
	private final TipoRelacionInstitucionBusiness business;

	public TipoRelacionInstitucionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
		business = new TipoRelacionInstitucionBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoRelacionInstitucionDTO> list(final TipoRelacionInstitucionDTO dto) {
		try {
			final var domain = TipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			
			return TipoRelacionInstitucionAssembler.getInstance().toDtoListFromDomainList(returnDomainList);
		}catch (final PubliUcoException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage = TipoRelacionInstitucionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoRelacionInstitucionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(userMessage, technicalMessage, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
}
