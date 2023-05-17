package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.SuscripcionCategoriaAssembler;
import co.edu.uco.publiuco.business.business.SuscripcionCategoriaBusiness;
import co.edu.uco.publiuco.business.domain.SuscripcionCategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.SuscripcionCategoriaEntity;

public final class SuscripcionCategoriaBusinessImpl implements SuscripcionCategoriaBusiness {

	DAOFactory daoFactory;

	public SuscripcionCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final SuscripcionCategoriaDomain domain) {
		final SuscripcionCategoriaEntity entity = SuscripcionCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getSuscripcionCategoriaDAO().create(entity);

	}

	@Override
	public List<SuscripcionCategoriaDomain> list(final SuscripcionCategoriaDomain domain) {
		final SuscripcionCategoriaEntity entity = SuscripcionCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);

		List<SuscripcionCategoriaEntity> resultEntityList = daoFactory.getSuscripcionCategoriaDAO().read(entity);

		return SuscripcionCategoriaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final SuscripcionCategoriaDomain domain) {
		final SuscripcionCategoriaEntity entity = SuscripcionCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getSuscripcionCategoriaDAO().update(entity);

	}

	@Override
	public void drop(final SuscripcionCategoriaDomain domain) {
		final SuscripcionCategoriaEntity entity = SuscripcionCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getSuscripcionCategoriaDAO().delete(entity);

	}
}
