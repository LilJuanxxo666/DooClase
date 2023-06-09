package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoRevisorAssembler;
import co.edu.uco.publiuco.business.business.EstadoRevisorBusiness;
import co.edu.uco.publiuco.business.domain.EstadoRevisorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoRevisorEntity;

public final class EstadoRevisorBusinessImpl implements EstadoRevisorBusiness {

	DAOFactory daoFactory;

	public EstadoRevisorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoRevisorDomain> list(final EstadoRevisorDomain domain) {
		final EstadoRevisorEntity entity = EstadoRevisorAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoRevisorEntity> resultEntityList = daoFactory.getEstadoRevisorDAO().read(entity);

		return EstadoRevisorAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
