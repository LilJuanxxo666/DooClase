package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoRevisionDomain;
import co.edu.uco.publiuco.dto.EstadoRevisionDTO;
import co.edu.uco.publiuco.entities.EstadoRevisionEntity;

public final class EstadoRevisionAssembler
		implements Assembler<EstadoRevisionDomain, EstadoRevisionDTO, EstadoRevisionEntity> {
	
	private static final Assembler<EstadoRevisionDomain, EstadoRevisionDTO, EstadoRevisionEntity> INSTANCE = new EstadoRevisionAssembler();

	private EstadoRevisionAssembler() {
		super();
	}

	public static Assembler<EstadoRevisionDomain, EstadoRevisionDTO, EstadoRevisionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoRevisionDTO toDtoFromDomain(final EstadoRevisionDomain domain) {
		return EstadoRevisionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoRevisionDomain toDomainFromDto(final EstadoRevisionDTO dto) {
		return new EstadoRevisionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoRevisionEntity toEntityFromDomain(final EstadoRevisionDomain domain) {
		return new EstadoRevisionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoRevisionDomain toDomainFromEntity(final EstadoRevisionEntity entity) {
		return new EstadoRevisionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}
}