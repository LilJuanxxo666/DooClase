package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.TipoReporteAssembler;
import co.edu.uco.publiuco.business.business.TipoReporteBusiness;
import co.edu.uco.publiuco.business.domain.TipoReporteDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoReporteEntity;

public final class TipoReporteBusinessImpl implements TipoReporteBusiness {

	DAOFactory daoFactory;

	public TipoReporteBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoReporteDomain> list(final TipoReporteDomain domain) {
		final TipoReporteEntity entity = TipoReporteAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoReporteEntity> resultEntityList = daoFactory.getTipoReporteDAO().read(entity);

		return TipoReporteAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
