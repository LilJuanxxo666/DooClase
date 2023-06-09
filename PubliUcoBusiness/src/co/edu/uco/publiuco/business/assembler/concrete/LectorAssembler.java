package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.LectorDomain;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.entities.LectorEntity;

public final class LectorAssembler implements Assembler<LectorDomain, LectorDTO, LectorEntity> {

	private static final Assembler<LectorDomain, LectorDTO, LectorEntity> INSTANCE = new LectorAssembler();

	private LectorAssembler() {
		super();
	}

	public static Assembler<LectorDomain, LectorDTO, LectorEntity> getInstance() {
		return INSTANCE;
	}
	

	@Override
	public LectorDTO toDtoFromDomain(final LectorDomain domain) {
		return LectorDTO.create().setIdentificador(domain.getIdentificador()).
				setTipoIdentifiacion(TipoIdentificacionAssembler.getInstance().toDtoFromDomain(domain.getTipoIdentificacion())).
				setNumeroIdentificacion(domain.getNumeroIdentificacion()).setPrimerNombre(domain.getPrimerNombre()).
				setSegundoNombre(domain.getSegundoNombre()).setPrimerApellido(domain.getPrimerApellido()).setSegundoApellido(domain.getSegundoApellido()).
				setCorreo(domain.getCorreo()).setIndicadorPaisTelefono(domain.getIndicadorPaisTelefono()).setTelefono(domain.getNumeroIdentificacion()).
				setCorreoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getCorreoConfirmado())).
				setTelefonoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getTelefonoConfirmado())).
				setEstado(EstadoLectorAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}
	
	@Override
	public LectorDomain toDomainFromDto(final LectorDTO dto) {
		return new LectorDomain(dto.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentifiacion()),
				dto.getNumeroIdentificacion(), dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(),
				dto.getSegundoApellido(), dto.getCorreo(), dto.getIndicadorPaisTelefono(), dto.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto.getRelacionInstitucion()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getTelefonoConfirmado()),
				EstadoLectorAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public LectorEntity toEntityFromDomain(final LectorDomain domain) {
		return new LectorEntity(domain.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),
				domain.getNumeroIdentificacion(), domain.getPrimerNombre(), domain.getSegundoNombre(),
				domain.getPrimerApellido(), domain.getSegundoApellido(), domain.getCorreo(), domain.getIndicadorPaisTelefono(),
				domain.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getTipoRelacion()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getTelefonoConfirmado()),
				EstadoLectorAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public LectorDomain toDomainFromEntity(final LectorEntity entity) {
		return new LectorDomain(entity.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
				entity.getNumeroIdentificacion(), entity.getPrimerNombre(), entity.getSegundoNombre(),
				entity.getPrimerApellido(), entity.getSegundoApellido(), entity.getCorreo(), entity.getIndicadorPaisTelefono(),
				entity.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getTipoRelacion()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getTelefonoConfirmado()),
				EstadoLectorAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<LectorDomain> toDomainListFromEntityList(List<LectorEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<LectorDTO> toDtoListFromDomainList(List<LectorDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
