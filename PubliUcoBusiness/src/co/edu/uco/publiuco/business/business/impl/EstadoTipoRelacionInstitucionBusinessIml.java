package co.edu.uco.publiuco.business.business.impl;

import java.util.List;


import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class EstadoTipoRelacionInstitucionBusinessIml implements EstadoTipoRelacionInstitucionBusiness{
	
	private DAOFactory daoFactory;
	
	public EstadoTipoRelacionInstitucionBusinessIml(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance().
				toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().create(entity);
	}

	@Override
	public final List<EstadoTipoRelacionInstitucionDomain> list(final EstadoTipoRelacionInstitucionDomain domain) {

        final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance()
                .toEntityFromDomain(domain);

        List<EstadoTipoRelacionInstitucionEntity> resultEntityList = daoFactory.getEstadoTipoRelacionInstitucionDAO()
                .read(entity);

        return EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
    }

	@Override
	public void modify(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance().
				toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().update(entity);

	}

	@Override
	public void drop(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance().
				toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().delete(entity);
	}
}
