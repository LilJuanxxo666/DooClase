package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoSuscripcionAssembler;
import co.edu.uco.publiuco.business.business.EstadoSuscripcionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoSuscripcionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoSuscripcionEntity;

public final class EstadoSuscripcionBusinessImpl implements EstadoSuscripcionBusiness {

	DAOFactory daoFactory;

	public EstadoSuscripcionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoSuscripcionDomain> list(final EstadoSuscripcionDomain domain) {
		final EstadoSuscripcionEntity entity = EstadoSuscripcionAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoSuscripcionEntity> resultEntityList = daoFactory.getEstadoSuscripcionDAO().read(entity);

		return EstadoSuscripcionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
