package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoRevisionAssembler;
import co.edu.uco.publiuco.business.business.TipoRevisionBusiness;
import co.edu.uco.publiuco.business.domain.TipoRevisionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoRevisionEntity;

public final class TipoRevisionBusinessImpl implements TipoRevisionBusiness {

	DAOFactory daoFactory;

	public TipoRevisionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoRevisionDomain> list(final TipoRevisionDomain domain) {
		final TipoRevisionEntity entity = TipoRevisionAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoRevisionEntity> resultEntityList = daoFactory.getTipoRevisionDAO().read(entity);

		return TipoRevisionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
