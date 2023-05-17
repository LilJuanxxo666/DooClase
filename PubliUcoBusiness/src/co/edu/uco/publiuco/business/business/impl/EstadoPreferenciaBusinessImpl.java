package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoPreferenciaAssembler;
import co.edu.uco.publiuco.business.business.EstadoPreferenciaBusiness;
import co.edu.uco.publiuco.business.domain.EstadoPreferenciaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoPreferenciaEntity;

public final class EstadoPreferenciaBusinessImpl implements EstadoPreferenciaBusiness {

	DAOFactory daoFactory;

	public EstadoPreferenciaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoPreferenciaDomain> list(final EstadoPreferenciaDomain domain) {
		final EstadoPreferenciaEntity entity = EstadoPreferenciaAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoPreferenciaEntity> resultEntityList = daoFactory.getEstadoPreferenciaDAO().read(entity);

		return EstadoPreferenciaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
