package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.RevisorAssembler;
import co.edu.uco.publiuco.business.business.RevisorBusiness;
import co.edu.uco.publiuco.business.domain.RevisorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.RevisorEntity;

public final class RevisorBusinessImpl implements RevisorBusiness {

	DAOFactory daoFactory;

	public RevisorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final RevisorDomain domain) {
		final RevisorEntity entity = RevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorDAO().create(entity);

	}

	@Override
	public List<RevisorDomain> list(final RevisorDomain domain) {
		final RevisorEntity entity = RevisorAssembler.getInstance().toEntityFromDomain(domain);

		List<RevisorEntity> resultEntityList = daoFactory.getRevisorDAO().read(entity);

		return RevisorAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final RevisorDomain domain) {
		final RevisorEntity entity = RevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorDAO().update(entity);

	}

	@Override
	public void drop(final RevisorDomain domain) {
		final RevisorEntity entity = RevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorDAO().delete(entity);

	}
}
