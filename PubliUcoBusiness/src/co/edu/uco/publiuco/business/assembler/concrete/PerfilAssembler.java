package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PerfilDomain;
import co.edu.uco.publiuco.dto.PerfilDTO;
import co.edu.uco.publiuco.entities.PerfilEntity;

public final class PerfilAssembler implements Assembler<PerfilDomain, PerfilDTO, PerfilEntity> {

	private static final Assembler<PerfilDomain, PerfilDTO, PerfilEntity> INSTANCE = new PerfilAssembler();

	private PerfilAssembler() {
		super();
	}

	public static Assembler<PerfilDomain, PerfilDTO, PerfilEntity> getInstance() {
		return INSTANCE;
	}
	

	@Override
	public PerfilDTO toDtoFromDomain(final PerfilDomain domain) {
		return PerfilDTO.create().setIdentificador(domain.getIdentificador()).
				setLector(LectorAssembler.getInstance().toDtoFromDomain(domain.getLector())).
				setRecomendacionAutor(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getRecomendacionAutor())).
				setRecomendacionCategoria(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getRecomendacionCategoria())).
				setEstado(EstadoLectorAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}
	
	@Override
	public PerfilDomain toDomainFromDto(final PerfilDTO dto) {
		return new PerfilDomain(dto.getIdentificador(), LectorAssembler.getInstance().toDomainFromDto(dto.getLector()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getRecomendacionCategoria()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getRecomendacionAutor()), 
				EstadoLectorAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public PerfilEntity toEntityFromDomain(final PerfilDomain domain) {
		return new PerfilEntity(domain.getIdentificador(),
				LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getRecomendacionCategoria()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getRecomendacionAutor()),
				EstadoLectorAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public PerfilDomain toDomainFromEntity(final PerfilEntity entity) {
		return new PerfilDomain(entity.getIdentificador(),
				LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getRecomendacionCategoria()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getRecomendacionAutor()), 
				EstadoLectorAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<PerfilDomain> toDomainListFromEntityList(List<PerfilEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<PerfilDTO> toDtoListFromDomainList(List<PerfilDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
