package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoIdentificacionDomain;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;
import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public final class TipoIdentificacionAssembler
		implements Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> {

	private static final Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> INSTANCE = new TipoIdentificacionAssembler();

	private TipoIdentificacionAssembler() {
		super();
	}

	public static Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoIdentificacionDTO toDtoFromDomain(final TipoIdentificacionDomain domain) {
		return TipoIdentificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion()).setEstado(EstadoTipoIdentificacionAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public TipoIdentificacionDomain toDomainFromDto(final TipoIdentificacionDTO dto) {
		return new TipoIdentificacionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion(),
				EstadoTipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public TipoIdentificacionEntity toEntityFromDomain(final TipoIdentificacionDomain domain) {
		return new TipoIdentificacionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion(),
				EstadoTipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public TipoIdentificacionDomain toDomainFromEntity(final TipoIdentificacionEntity entity) {
		return new TipoIdentificacionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion(),
				EstadoTipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}
}
