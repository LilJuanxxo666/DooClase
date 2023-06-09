package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.PalabraClavePublicacionAssembler;
import co.edu.uco.publiuco.business.business.PalabraClavePublicacionBusiness;
import co.edu.uco.publiuco.business.domain.PalabraClavePublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PalabraClavePublicacionEntity;

public final class PalabraClavePublicacionBusinessImpl implements PalabraClavePublicacionBusiness {

	DAOFactory daoFactory;

	public PalabraClavePublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final PalabraClavePublicacionDomain domain) {
		final PalabraClavePublicacionEntity entity = PalabraClavePublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getPalabraClavePublicacionDAO().create(entity);

	}

	@Override
	public List<PalabraClavePublicacionDomain> list(final PalabraClavePublicacionDomain domain) {
		final PalabraClavePublicacionEntity entity = PalabraClavePublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);

		List<PalabraClavePublicacionEntity> resultEntityList = daoFactory.getPalabraClavePublicacionDAO().read(entity);

		return PalabraClavePublicacionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final PalabraClavePublicacionDomain domain) {
		final PalabraClavePublicacionEntity entity = PalabraClavePublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getPalabraClavePublicacionDAO().update(entity);

	}

	@Override
	public void drop(final PalabraClavePublicacionDomain domain) {
		final PalabraClavePublicacionEntity entity = PalabraClavePublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getPalabraClavePublicacionDAO().delete(entity);

	}
}
