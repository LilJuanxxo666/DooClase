package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoRevisionDomain;
import co.edu.uco.publiuco.dto.TipoRevisionDTO;
import co.edu.uco.publiuco.entities.TipoRevisionEntity;

public final class TipoRevisionAssembler implements Assembler<TipoRevisionDomain, TipoRevisionDTO, TipoRevisionEntity> {
	
	private static final Assembler<TipoRevisionDomain, TipoRevisionDTO, TipoRevisionEntity> INSTANCE = new TipoRevisionAssembler();

	private TipoRevisionAssembler() {
		super();
	}

	public static Assembler<TipoRevisionDomain, TipoRevisionDTO, TipoRevisionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoRevisionDTO toDtoFromDomain(final TipoRevisionDomain domain) {
		return TipoRevisionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoRevisionDomain toDomainFromDto(final TipoRevisionDTO dto) {
		return new TipoRevisionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoRevisionEntity toEntityFromDomain(final TipoRevisionDomain domain) {
		return new TipoRevisionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoRevisionDomain toDomainFromEntity(final TipoRevisionEntity entity) {
		return new TipoRevisionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoRevisionDomain> toDomainListFromEntityList(List<TipoRevisionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoRevisionDTO> toDtoListFromDomainList(List<TipoRevisionDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}
