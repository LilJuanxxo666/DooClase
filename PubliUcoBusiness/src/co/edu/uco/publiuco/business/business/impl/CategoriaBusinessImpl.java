package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.CategoriaAssembler;
import co.edu.uco.publiuco.business.business.CategoriaBusiness;
import co.edu.uco.publiuco.business.domain.CategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CategoriaEntity;

public final class CategoriaBusinessImpl implements CategoriaBusiness {

	DAOFactory daoFactory;

	public CategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().create(entity);

	}

	@Override
	public List<CategoriaDomain> list(final CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);

		List<CategoriaEntity> resultEntityList = daoFactory.getCategoriaDAO()
				.read(entity);

		return CategoriaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().update(entity);

	}

	@Override
	public void drop(final CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().delete(entity);

	}
}
