package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoObservacionRevisorDomain;
import co.edu.uco.publiuco.dto.EstadoObservacionRevisorDTO;
import co.edu.uco.publiuco.entities.EstadoObservacionRevisorEntity;

public final class EstadoObservacionRevisorAssembler implements
		Assembler<EstadoObservacionRevisorDomain, EstadoObservacionRevisorDTO, EstadoObservacionRevisorEntity> {

	private static final Assembler<EstadoObservacionRevisorDomain, EstadoObservacionRevisorDTO, EstadoObservacionRevisorEntity> INSTANCE = new EstadoObservacionRevisorAssembler();

	private EstadoObservacionRevisorAssembler() {
		super();
	}

	public static Assembler<EstadoObservacionRevisorDomain, EstadoObservacionRevisorDTO, EstadoObservacionRevisorEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoObservacionRevisorDTO toDtoFromDomain(final EstadoObservacionRevisorDomain domain) {
		return EstadoObservacionRevisorDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoObservacionRevisorDomain toDomainFromDto(final EstadoObservacionRevisorDTO dto) {
		return new EstadoObservacionRevisorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoObservacionRevisorEntity toEntityFromDomain(final EstadoObservacionRevisorDomain domain) {
		return new EstadoObservacionRevisorEntity(domain.getIdentificador(), domain.getNombre(),
				domain.getDescripcion());
	}

	@Override
	public EstadoObservacionRevisorDomain toDomainFromEntity(final EstadoObservacionRevisorEntity entity) {
		return new EstadoObservacionRevisorDomain(entity.getIdentificador(), entity.getNombre(),
				entity.getDescripcion());
	}
}