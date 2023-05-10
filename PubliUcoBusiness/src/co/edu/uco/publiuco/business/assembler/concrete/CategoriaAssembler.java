package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.CategoriaDomain;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.entities.CategoriaEntity;

public final class CategoriaAssembler implements Assembler<CategoriaDomain, CategoriaDTO, CategoriaEntity> {

	private static final Assembler<CategoriaDomain, CategoriaDTO, CategoriaEntity> INSTANCE = new CategoriaAssembler();

	private CategoriaAssembler() {
		super();
	}

	public static Assembler<CategoriaDomain, CategoriaDTO, CategoriaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public CategoriaDTO toDtoFromDomain(final CategoriaDomain domain) {
		return CategoriaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion()).setCategoriaPadre(CategoriaAssembler.getInstance().
						toDtoFromDomain(domain.getCategoriaPadre())).
				setEstadoCategoria(EstadoCategoriaAssembler.getInstance().toDtoFromDomain(domain.getEstadoCategoria())).
				setEstadoPreferencia(EstadoPreferenciaAssembler.getInstance().toDtoFromDomain(domain.getEstadoPreferencia()));
	}

	@Override
	public CategoriaDomain toDomainFromDto(final CategoriaDTO dto) {
		return new CategoriaDomain(dto.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromDto(dto.getCategoriaPadre()), dto.getNombre(),
				dto.getDescripcion(), EstadoCategoriaAssembler.getInstance().toDomainFromDto(dto.getEstadoCategoria()),
				EstadoPreferenciaAssembler.getInstance().toDomainFromDto(dto.getEstadoPreferencia()));
	}

	@Override
	public CategoriaEntity toEntityFromDomain(final CategoriaDomain domain) {
		return new CategoriaEntity(domain.getIdentificador(),
				CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoriaPadre()), domain.getNombre(),
				domain.getDescripcion(), EstadoCategoriaAssembler.getInstance().toEntityFromDomain(domain.getEstadoCategoria()),
				EstadoPreferenciaAssembler.getInstance().toEntityFromDomain(domain.getEstadoPreferencia()));
	}

	@Override
	public CategoriaDomain toDomainFromEntity(CategoriaEntity entity) {
		return new CategoriaDomain(entity.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoriaPadre()), entity.getNombre(),
				entity.getDescripcion(), EstadoCategoriaAssembler.getInstance().toDomainFromEntity(entity.getEstadoCategoria()), 
				EstadoPreferenciaAssembler.getInstance().toDomainFromEntity(entity.getEstadoPreferencia()));
	}

	@Override
	public List<CategoriaDomain> toDomainListFromEntityList(List<CategoriaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<CategoriaDTO> toDtoListFromDomainList(List<CategoriaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}
