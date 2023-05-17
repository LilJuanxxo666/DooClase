package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.CategoriaAdministradorCategoriaAssembler;
import co.edu.uco.publiuco.business.business.CategoriaAdministradorCategoriaBusiness;
import co.edu.uco.publiuco.business.domain.CategoriaAdministradorCategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CategoriaAdministradorCategoriaEntity;

public final class CategoriaAdministradorCategoriaBusinessImpl implements CategoriaAdministradorCategoriaBusiness {

	DAOFactory daoFactory;

	public CategoriaAdministradorCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final CategoriaAdministradorCategoriaDomain domain) {
		final CategoriaAdministradorCategoriaEntity entity = CategoriaAdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getCategoriaAdministradorCategoriaDAO().create(entity);

	}

	@Override
	public List<CategoriaAdministradorCategoriaDomain> list(final CategoriaAdministradorCategoriaDomain domain) {
		final CategoriaAdministradorCategoriaEntity entity = CategoriaAdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);

		List<CategoriaAdministradorCategoriaEntity> resultEntityList = daoFactory
				.getCategoriaAdministradorCategoriaDAO().read(entity);

		return CategoriaAdministradorCategoriaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final CategoriaAdministradorCategoriaDomain domain) {
		final CategoriaAdministradorCategoriaEntity entity = CategoriaAdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getCategoriaAdministradorCategoriaDAO().update(entity);

	}

	@Override
	public void drop(final CategoriaAdministradorCategoriaDomain domain) {
		final CategoriaAdministradorCategoriaEntity entity = CategoriaAdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getCategoriaAdministradorCategoriaDAO().delete(entity);

	}
}
