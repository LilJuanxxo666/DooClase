package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.RespuestaDomain;
import co.edu.uco.publiuco.dto.RespuestaDTO;
import co.edu.uco.publiuco.entities.RespuestaEntity;

public final class RespuestaAssembler implements Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> {
	
	private static final Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> INSTANCE = new RespuestaAssembler();

	private RespuestaAssembler() {
		super();
	}

	public static Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public RespuestaDTO toDtoFromDomain(final RespuestaDomain domain) {
		return RespuestaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public RespuestaDomain toDomainFromDto(final RespuestaDTO dto) {
		return new RespuestaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public RespuestaEntity toEntityFromDomain(final RespuestaDomain domain) {
		return new RespuestaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public RespuestaDomain toDomainFromEntity(final RespuestaEntity entity) {
		return new RespuestaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}
}