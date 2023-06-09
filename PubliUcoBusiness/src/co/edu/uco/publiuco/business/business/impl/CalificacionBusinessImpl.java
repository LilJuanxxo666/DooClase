package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.CalificacionAssembler;
import co.edu.uco.publiuco.business.business.CalificacionBusiness;
import co.edu.uco.publiuco.business.domain.CalificacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CalificacionEntity;

public final class CalificacionBusinessImpl implements CalificacionBusiness{
	
	DAOFactory daoFactory;

	public CalificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final CalificacionDomain domain) {
		final CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCalificacionDAO().create(entity);

	}

	@Override
	public List<CalificacionDomain> list(final CalificacionDomain domain) {
		final CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);

		List<CalificacionEntity> resultEntityList = daoFactory.getCalificacionDAO().read(entity);

		return CalificacionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final CalificacionDomain domain) {
		final CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCalificacionDAO().update(entity);

	}

	@Override
	public void drop(final CalificacionDomain domain) {
		final CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCalificacionDAO().delete(entity);

	}
}