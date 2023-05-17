package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.RevisorRevisionAssembler;
import co.edu.uco.publiuco.business.business.RevisorRevisionBusiness;
import co.edu.uco.publiuco.business.domain.RevisorRevisionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.RevisorRevisionEntity;

public final class RevisorRevisionBusinessImpl implements RevisorRevisionBusiness {

	DAOFactory daoFactory;

	public RevisorRevisionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final RevisorRevisionDomain domain) {
		final RevisorRevisionEntity entity = RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorRevisionDAO().create(entity);

	}

	@Override
	public List<RevisorRevisionDomain> list(final RevisorRevisionDomain domain) {
		final RevisorRevisionEntity entity = RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain);

		List<RevisorRevisionEntity> resultEntityList = daoFactory.getRevisorRevisionDAO().read(entity);

		return RevisorRevisionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final RevisorRevisionDomain domain) {
		final RevisorRevisionEntity entity = RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorRevisionDAO().update(entity);

	}

	@Override
	public void drop(final RevisorRevisionDomain domain) {
		final RevisorRevisionEntity entity = RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorRevisionDAO().delete(entity);

	}
}
