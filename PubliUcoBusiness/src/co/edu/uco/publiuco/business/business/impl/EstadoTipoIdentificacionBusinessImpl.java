package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoIdentificacionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoIdentificacionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoTipoIdentificacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoIdentificacionEntity;

public final class EstadoTipoIdentificacionBusinessImpl implements EstadoTipoIdentificacionBusiness {

	DAOFactory daoFactory;

	public EstadoTipoIdentificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoTipoIdentificacionDomain> list(final EstadoTipoIdentificacionDomain domain) {
		final EstadoTipoIdentificacionEntity entity = EstadoTipoIdentificacionAssembler.getInstance()
				.toEntityFromDomain(domain);

		List<EstadoTipoIdentificacionEntity> resultEntityList = daoFactory.getEstadoTipoIdentificacionDAO()
				.read(entity);

		return EstadoTipoIdentificacionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
}
