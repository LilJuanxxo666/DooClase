package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoVersionAssembler;
import co.edu.uco.publiuco.business.business.EstadoVersionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoVersionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoVersionEntity;

public final class EstadoVersionBusinessImpl implements EstadoVersionBusiness {

	DAOFactory daoFactory;

	public EstadoVersionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoVersionDomain> list(final EstadoVersionDomain domain) {
		final EstadoVersionEntity entity = EstadoVersionAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoVersionEntity> resultEntityList = daoFactory.getEstadoVersionDAO().read(entity);

		return EstadoVersionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
