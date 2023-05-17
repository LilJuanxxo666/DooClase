package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoPublicacionAssembler;
import co.edu.uco.publiuco.business.business.EstadoPublicacionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoPublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoPublicacionEntity;

public final class EstadoPublicacionBusinessImpl implements EstadoPublicacionBusiness {

	DAOFactory daoFactory;

	public EstadoPublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoPublicacionDomain> list(final EstadoPublicacionDomain domain) {
		final EstadoPublicacionEntity entity = EstadoPublicacionAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoPublicacionEntity> resultEntityList = daoFactory.getEstadoPublicacionDAO().read(entity);

		return EstadoPublicacionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
