package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;

import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public final class TipoRelacionInstitucionAssembler
		implements Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> {
	
	private static final Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> INSTANCE = new TipoRelacionInstitucionAssembler();

	private TipoRelacionInstitucionAssembler() {
		super();
	}

	public static Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoRelacionInstitucionDTO toDtoFromDomain(final TipoRelacionInstitucionDomain domain) {
		return TipoRelacionInstitucionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion()).setEstado(EstadoTipoRelacionInstitucionAssembler.getInstance().
						toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public TipoRelacionInstitucionDomain toDomainFromDto(final TipoRelacionInstitucionDTO dto) {
		return new TipoRelacionInstitucionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion(), EstadoTipoRelacionInstitucionAssembler.
				getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public TipoRelacionInstitucionEntity toEntityFromDomain(final TipoRelacionInstitucionDomain domain) {
		return new TipoRelacionInstitucionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion(), 
				EstadoTipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public TipoRelacionInstitucionDomain toDomainFromEntity(final TipoRelacionInstitucionEntity entity) {
		return new TipoRelacionInstitucionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion(), 
				EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<TipoRelacionInstitucionDomain> toDomainListFromEntityList(List<TipoRelacionInstitucionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoRelacionInstitucionDTO> toDtoListFromDomainList(List<TipoRelacionInstitucionDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
