package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PublicacionDomain;
import co.edu.uco.publiuco.dto.PublicacionDTO;
import co.edu.uco.publiuco.entities.PublicacionEntity;

public final class PublicacionAssembler implements Assembler<PublicacionDomain, PublicacionDTO, PublicacionEntity> {

	private static final Assembler<PublicacionDomain, PublicacionDTO, PublicacionEntity> INSTANCE = new PublicacionAssembler();

	private PublicacionAssembler() {
		super();
	}

	public static Assembler<PublicacionDomain, PublicacionDTO, PublicacionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public PublicacionDTO toDtoFromDomain(final PublicacionDomain domain) {
		return PublicacionDTO.create().setIdentificador(domain.getIdentificador()).
				setCategoria(CategoriaAssembler.getInstance().toDtoFromDomain(domain.getCategoria())).
				setFechaPublicacion(domain.getFechaPublicacion()).
				setTipoAcceso(TipoAccesoAssembler.getInstance().toDtoFromDomain(domain.getTipoAcceso())).
				setEstado(EstadoPublicacionAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public PublicacionDomain toDomainFromDto(final PublicacionDTO dto) {
		return new PublicacionDomain(dto.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromDto(dto.getCategoria()),
				TipoAccesoAssembler.getInstance().toDomainFromDto(dto.getTipoAcceso()), dto.getFechaPublicacion(),
				EstadoPublicacionAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public PublicacionEntity toEntityFromDomain(final PublicacionDomain domain) {
		return new PublicacionEntity(domain.getIdentificador(),
				CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()),
				TipoAccesoAssembler.getInstance().toEntityFromDomain(domain.getTipoAcceso()),
				domain.getFechaPublicacion(),
				EstadoPublicacionAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public PublicacionDomain toDomainFromEntity(final PublicacionEntity entity) {
		return new PublicacionDomain(entity.getIdentificador(),
				CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()),
				TipoAccesoAssembler.getInstance().toDomainFromEntity(entity.getTipoAcceso()),
				entity.getFechaPublicacion(),
				EstadoPublicacionAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<PublicacionDomain> toDomainListFromEntityList(List<PublicacionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<PublicacionDTO> toDtoListFromDomainList(List<PublicacionDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
