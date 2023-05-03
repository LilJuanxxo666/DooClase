package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PlanCategoriaDomain;
import co.edu.uco.publiuco.dto.PlanCategoriaDTO;
import co.edu.uco.publiuco.entities.PlanCategoriaEntity;

public final class PlanCategoriaAssembler implements Assembler<PlanCategoriaDomain, PlanCategoriaDTO, PlanCategoriaEntity> {

	private static final Assembler<PlanCategoriaDomain, PlanCategoriaDTO, PlanCategoriaEntity> INSTANCE = new PlanCategoriaAssembler();

	private PlanCategoriaAssembler() {
		super();
	}

	public static Assembler<PlanCategoriaDomain, PlanCategoriaDTO, PlanCategoriaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public PlanCategoriaDTO toDtoFromDomain(final PlanCategoriaDomain domain) {
		return PlanCategoriaDTO.create().setIdentificador(domain.getIdentificador()).
				setCategoria(CategoriaAssembler.getInstance().toDtoFromDomain(domain.getCategoria())).setPrecio(domain.getPrecio()).
				setFechaDesde(domain.getFechaDesde()).setFechaHasta(domain.getFechaHasta()).
				setEstado(EstadoSuscripcionAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public PlanCategoriaDomain toDomainFromDto(final PlanCategoriaDTO dto) {
		return new PlanCategoriaDomain(dto.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromDto(dto.getCategoria()), dto.getPrecio(),
				dto.getFechaDesde(), dto.getFechaHasta(), EstadoSuscripcionAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public PlanCategoriaEntity toEntityFromDomain(final PlanCategoriaDomain domain) {
		return new PlanCategoriaEntity(domain.getIdentificador(),
				CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()), domain.getPrecio(),
				domain.getFechaDesde(), domain.getFechaHasta(), EstadoSuscripcionAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public PlanCategoriaDomain toDomainFromEntity(final PlanCategoriaEntity entity) {
		return new PlanCategoriaDomain(entity.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()), entity.getPrecio(),
				entity.getFechaDesde(), entity.getFechaHasta(), EstadoSuscripcionAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}
}
