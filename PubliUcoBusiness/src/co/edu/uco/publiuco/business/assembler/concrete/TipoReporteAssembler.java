package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;

import co.edu.uco.publiuco.business.domain.TipoReporteDomain;
import co.edu.uco.publiuco.dto.TipoReporteDTO;
import co.edu.uco.publiuco.entities.TipoReporteEntity;

public final class TipoReporteAssembler implements Assembler<TipoReporteDomain, TipoReporteDTO, TipoReporteEntity> {
	
	private static final Assembler<TipoReporteDomain, TipoReporteDTO, TipoReporteEntity> INSTANCE = new TipoReporteAssembler();

	private TipoReporteAssembler() {
		super();
	}

	public static Assembler<TipoReporteDomain, TipoReporteDTO, TipoReporteEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoReporteDTO toDtoFromDomain(final TipoReporteDomain domain) {
		return TipoReporteDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoReporteDomain toDomainFromDto(final TipoReporteDTO dto) {
		return new TipoReporteDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoReporteEntity toEntityFromDomain(final TipoReporteDomain domain) {
		return new TipoReporteEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoReporteDomain toDomainFromEntity(final TipoReporteEntity entity) {
		return new TipoReporteDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoReporteDomain> toDomainListFromEntityList(List<TipoReporteEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoReporteDTO> toDtoListFromDomainList(List<TipoReporteDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
