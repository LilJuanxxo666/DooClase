package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.CategoriaAdministradorCategoriaDomain;
import co.edu.uco.publiuco.dto.CategoriaAdministradorCategoriaDTO;
import co.edu.uco.publiuco.entities.CategoriaAdministradorCategoriaEntity;

public final class CategoriaAdministradorCategoriaAssembler implements
		Assembler<CategoriaAdministradorCategoriaDomain, CategoriaAdministradorCategoriaDTO, CategoriaAdministradorCategoriaEntity> {

	private static final Assembler<CategoriaAdministradorCategoriaDomain, CategoriaAdministradorCategoriaDTO, CategoriaAdministradorCategoriaEntity> INSTANCE = new CategoriaAdministradorCategoriaAssembler();

	private CategoriaAdministradorCategoriaAssembler() {
		super();
	}

	public static Assembler<CategoriaAdministradorCategoriaDomain, CategoriaAdministradorCategoriaDTO, CategoriaAdministradorCategoriaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public CategoriaAdministradorCategoriaDTO toDtoFromDomain(final CategoriaAdministradorCategoriaDomain domain) {
		return null;
	}

	@Override
	public CategoriaAdministradorCategoriaDomain toDomainFromDto(final CategoriaAdministradorCategoriaDTO dto) {
		return new CategoriaAdministradorCategoriaDomain(dto.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromDto(dto.getCategoria()),
				AdministradorCategoriaAssembler.getInstance().toDomainFromDto(dto.getAdministradorCategoria()),
				EstadoCategoriaAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public CategoriaAdministradorCategoriaEntity toEntityFromDomain(final CategoriaAdministradorCategoriaDomain domain) {
		return new CategoriaAdministradorCategoriaEntity(domain.getIdentificador(),
				CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()),
				AdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain.getAdministradorCategoria()),
				EstadoCategoriaAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public CategoriaAdministradorCategoriaDomain toDomainFromEntity(final CategoriaAdministradorCategoriaEntity entity) {
		return new CategoriaAdministradorCategoriaDomain(entity.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()),
				AdministradorCategoriaAssembler.getInstance().toDomainFromEntity(entity.getAdministradorCategoria()), 
				EstadoCategoriaAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<CategoriaAdministradorCategoriaDomain> toDomainListFromEntityList(
			List<CategoriaAdministradorCategoriaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<CategoriaAdministradorCategoriaDTO> toDtoListFromDomainList(
			List<CategoriaAdministradorCategoriaDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
