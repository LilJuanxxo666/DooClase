package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoPreferenciaDomain;
import co.edu.uco.publiuco.dto.EstadoPreferenciaDTO;
import co.edu.uco.publiuco.entities.EstadoPreferenciaEntity;

public final class EstadoPreferenciaAssembler
		implements Assembler<EstadoPreferenciaDomain, EstadoPreferenciaDTO, EstadoPreferenciaEntity> {
	
	private static final Assembler<EstadoPreferenciaDomain, EstadoPreferenciaDTO, EstadoPreferenciaEntity> INSTANCE = new EstadoPreferenciaAssembler();

	private EstadoPreferenciaAssembler() {
		super();
	}

	public static Assembler<EstadoPreferenciaDomain, EstadoPreferenciaDTO, EstadoPreferenciaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoPreferenciaDTO toDtoFromDomain(final EstadoPreferenciaDomain domain) { 
		return EstadoPreferenciaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoPreferenciaDomain toDomainFromDto(final EstadoPreferenciaDTO dto) {
		return new EstadoPreferenciaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoPreferenciaEntity toEntityFromDomain(final EstadoPreferenciaDomain domain) {
		return new EstadoPreferenciaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoPreferenciaDomain toDomainFromEntity(final EstadoPreferenciaEntity entity) {
		return new EstadoPreferenciaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<EstadoPreferenciaDomain> toDomainListFromEntityList(List<EstadoPreferenciaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
}
