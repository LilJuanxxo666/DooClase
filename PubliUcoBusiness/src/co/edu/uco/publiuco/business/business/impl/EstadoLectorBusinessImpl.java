package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoLectorAssembler;
import co.edu.uco.publiuco.business.business.EstadoLectorBusiness;
import co.edu.uco.publiuco.business.domain.EstadoLectorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoLectorEntity;

public final class EstadoLectorBusinessImpl implements EstadoLectorBusiness {

	DAOFactory daoFactory;

	public EstadoLectorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoLectorDomain> list(final EstadoLectorDomain domain) {
		final EstadoLectorEntity entity = EstadoLectorAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoLectorEntity> resultEntityList = daoFactory.getEstadoLectorDAO().read(entity);

		return EstadoLectorAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
