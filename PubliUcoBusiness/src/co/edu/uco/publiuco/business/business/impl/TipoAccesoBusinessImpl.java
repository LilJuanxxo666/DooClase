package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoAccesoAssembler;
import co.edu.uco.publiuco.business.business.TipoAccesoBusiness;
import co.edu.uco.publiuco.business.domain.TipoAccesoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public final class TipoAccesoBusinessImpl implements TipoAccesoBusiness {

	DAOFactory daoFactory;

	public TipoAccesoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoAccesoDomain> list(final TipoAccesoDomain domain) {
		final TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoAccesoEntity> resultEntityList = daoFactory.getTipoAccesoDAO().read(entity);

		return TipoAccesoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
