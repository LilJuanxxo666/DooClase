package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoSuscripcionDomain;
import co.edu.uco.publiuco.dto.EstadoSuscripcionDTO;
import co.edu.uco.publiuco.entities.EstadoSuscripcionEntity;

public final class EstadoSuscripcionAssembler
		implements Assembler<EstadoSuscripcionDomain, EstadoSuscripcionDTO, EstadoSuscripcionEntity> {
	
	private static final Assembler<EstadoSuscripcionDomain, EstadoSuscripcionDTO, EstadoSuscripcionEntity> INSTANCE = new EstadoSuscripcionAssembler();

	private EstadoSuscripcionAssembler() {
		super();
	}

	public static Assembler<EstadoSuscripcionDomain, EstadoSuscripcionDTO, EstadoSuscripcionEntity> getInstance() {
		return INSTANCE;
	}
	@Override
	public EstadoSuscripcionDTO toDtoFromDomain(final EstadoSuscripcionDomain domain) {
		return EstadoSuscripcionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoSuscripcionDomain toDomainFromDto(final EstadoSuscripcionDTO dto) {
		return new EstadoSuscripcionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoSuscripcionEntity toEntityFromDomain(final EstadoSuscripcionDomain domain) {
		return new EstadoSuscripcionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoSuscripcionDomain toDomainFromEntity(final EstadoSuscripcionEntity entity) {
		return new EstadoSuscripcionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}



}
