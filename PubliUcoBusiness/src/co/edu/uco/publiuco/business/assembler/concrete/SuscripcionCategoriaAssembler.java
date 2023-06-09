package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.SuscripcionCategoriaDomain;
import co.edu.uco.publiuco.dto.SuscripcionCategoriaDTO;
import co.edu.uco.publiuco.entities.SuscripcionCategoriaEntity;

public final class SuscripcionCategoriaAssembler
		implements Assembler<SuscripcionCategoriaDomain, SuscripcionCategoriaDTO, SuscripcionCategoriaEntity> {

	private static final Assembler<SuscripcionCategoriaDomain, SuscripcionCategoriaDTO, SuscripcionCategoriaEntity> INSTANCE = new SuscripcionCategoriaAssembler();

	private SuscripcionCategoriaAssembler() {
		super();
	}

	public static Assembler<SuscripcionCategoriaDomain, SuscripcionCategoriaDTO, SuscripcionCategoriaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public SuscripcionCategoriaDTO toDtoFromDomain(final SuscripcionCategoriaDomain domain) {
		return SuscripcionCategoriaDTO.create().setIdentificador(domain.getIdentificador())
				.setPerfil(PerfilAssembler.getInstance().toDtoFromDomain(domain.getPerfil()))
				.setPlanCategoria(PlanCategoriaAssembler.getInstance().toDtoFromDomain(domain.getPlanCategoria()).
						setEstado(EstadoSuscripcionAssembler.getInstance().toDtoFromDomain(domain.getEstado())));
	}

	@Override
	public SuscripcionCategoriaDomain toDomainFromDto(final SuscripcionCategoriaDTO dto) {
		return new SuscripcionCategoriaDomain(dto.getIdentificador(),
				PerfilAssembler.getInstance().toDomainFromDto(dto.getPerfil()),
				PlanCategoriaAssembler.getInstance().toDomainFromDto(dto.getPlanCategoria()), 
				EstadoSuscripcionAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public SuscripcionCategoriaEntity toEntityFromDomain(final SuscripcionCategoriaDomain domain) {
		return new SuscripcionCategoriaEntity(domain.getIdentificador(),
				PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()),
				PlanCategoriaAssembler.getInstance().toEntityFromDomain(domain.getPlanCategoria()),
				EstadoSuscripcionAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public SuscripcionCategoriaDomain toDomainFromEntity(final SuscripcionCategoriaEntity entity) {
		return new SuscripcionCategoriaDomain(entity.getIdentificador(),
				PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()),
				PlanCategoriaAssembler.getInstance().toDomainFromEntity(entity.getPlanCategoria()),
				EstadoSuscripcionAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<SuscripcionCategoriaDomain> toDomainListFromEntityList(List<SuscripcionCategoriaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<SuscripcionCategoriaDTO> toDtoListFromDomainList(List<SuscripcionCategoriaDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
