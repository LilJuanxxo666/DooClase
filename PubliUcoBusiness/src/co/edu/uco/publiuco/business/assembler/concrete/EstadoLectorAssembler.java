package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoLectorDomain;
import co.edu.uco.publiuco.dto.EstadoLectorDTO;
import co.edu.uco.publiuco.entities.EstadoLectorEntity;

public final class EstadoLectorAssembler implements Assembler<EstadoLectorDomain, EstadoLectorDTO, EstadoLectorEntity> {

	private static final Assembler<EstadoLectorDomain, EstadoLectorDTO, EstadoLectorEntity> INSTANCE = new EstadoLectorAssembler();

	private EstadoLectorAssembler() {
		super();
	}

	public static Assembler<EstadoLectorDomain, EstadoLectorDTO, EstadoLectorEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoLectorDTO toDtoFromDomain(final EstadoLectorDomain domain) {
		return EstadoLectorDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoLectorDomain toDomainFromDto(final EstadoLectorDTO dto) {
		return new EstadoLectorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoLectorEntity toEntityFromDomain(final EstadoLectorDomain domain) {
		return new EstadoLectorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoLectorDomain toDomainFromEntity(final EstadoLectorEntity entity) {
		return new EstadoLectorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<EstadoLectorDomain> toDomainListFromEntityList(List<EstadoLectorEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<EstadoLectorDTO> toDtoListFromDomainList(List<EstadoLectorDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
