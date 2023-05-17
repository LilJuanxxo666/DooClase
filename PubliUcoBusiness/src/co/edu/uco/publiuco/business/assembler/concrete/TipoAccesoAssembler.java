package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoAccesoDomain;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public final class TipoAccesoAssembler implements Assembler<TipoAccesoDomain, TipoAccesoDTO, TipoAccesoEntity> {

	private static final Assembler<TipoAccesoDomain, TipoAccesoDTO, TipoAccesoEntity> INSTANCE = new TipoAccesoAssembler();

	private TipoAccesoAssembler() {
		super();
	}

	public static final Assembler<TipoAccesoDomain, TipoAccesoDTO, TipoAccesoEntity> getInstance() {
		return INSTANCE;
	}
	
	@Override
	public TipoAccesoDTO toDtoFromDomain(final TipoAccesoDomain domain) {
		return TipoAccesoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion()).setEstado(EstadoTipoAccesoAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}
	
	@Override
	public TipoAccesoDomain toDomainFromDto(final TipoAccesoDTO dto) {
		return new TipoAccesoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion(),
				EstadoTipoAccesoAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public TipoAccesoEntity toEntityFromDomain(final TipoAccesoDomain domain) {
		return new TipoAccesoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion(),
				EstadoTipoAccesoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public TipoAccesoDomain toDomainFromEntity(final TipoAccesoEntity entity) {
		return new TipoAccesoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion(),
				EstadoTipoAccesoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<TipoAccesoDomain> toDomainListFromEntityList(List<TipoAccesoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoAccesoDTO> toDtoListFromDomainList(List<TipoAccesoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
