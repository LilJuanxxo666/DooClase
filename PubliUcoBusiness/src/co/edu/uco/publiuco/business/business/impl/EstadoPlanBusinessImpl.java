package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoPlanAssembler;
import co.edu.uco.publiuco.business.business.EstadoPlanBusiness;
import co.edu.uco.publiuco.business.domain.EstadoPlanDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoPlanEntity;

public final class EstadoPlanBusinessImpl implements EstadoPlanBusiness {

	DAOFactory daoFactory;

	public EstadoPlanBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoPlanDomain> list(final EstadoPlanDomain domain) {
		final EstadoPlanEntity entity = EstadoPlanAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoPlanEntity> resultEntityList = daoFactory.getEstadoPlanDAO().read(entity);

		return EstadoPlanAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
