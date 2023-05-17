package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.RevisorDomain;
import co.edu.uco.publiuco.dto.RevisorDTO;
import co.edu.uco.publiuco.entities.RevisorEntity;

public final class RevisorAssembler implements Assembler<RevisorDomain, RevisorDTO, RevisorEntity> {
	
	private static final Assembler<RevisorDomain, RevisorDTO, RevisorEntity> INSTANCE = new RevisorAssembler();

	private RevisorAssembler() {
		super();
	}

	public static Assembler<RevisorDomain, RevisorDTO, RevisorEntity> getInstance() {
		return INSTANCE;
	}
	
	@Override
	public RevisorDTO toDtoFromDomain(final RevisorDomain domain) {
		return RevisorDTO.create().setIdentificador(domain.getIdentificador()).
				setTipoIdentifiacion(TipoIdentificacionAssembler.getInstance().toDtoFromDomain(domain.getTipoIdentificacion())).
				setPrimerNombre(domain.getPrimerNombre()).setSegundoNombre(domain.getSegundoNombre()).
				setPrimerApellido(domain.getSegundoApellido()).setSegundoApellido(domain.getSegundoApellido()).
				setCorreo(domain.getCorreo()).setIndicadorPaisTelefono(domain.getIndicadorPaisTelefono()).setTelefono(domain.getTelefono()).
				setCorreoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getCorreoConfirmado())).
				setTelefonoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getTelefonoConfirmado())).
				setEstado(EstadoRevisorAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public RevisorDomain toDomainFromDto(final RevisorDTO dto) {
		return new RevisorDomain(dto.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentifiacion()),
				dto.getNumeroIdentificacion(), dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(),
				dto.getSegundoApellido(), dto.getCorreo(), dto.getIndicadorPaisTelefono(), dto.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto.getRelacionInstitucion()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getTelefonoConfirmado()),
				EstadoRevisorAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public RevisorEntity toEntityFromDomain(final RevisorDomain domain) {
		return new RevisorEntity(domain.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),
				domain.getNumeroIdentificacion(), domain.getPrimerNombre(), domain.getSegundoNombre(),
				domain.getPrimerApellido(), domain.getSegundoApellido(), domain.getCorreo(), domain.getIndicadorPaisTelefono(),
				domain.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getTipoRelacion()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getTelefonoConfirmado()),
				EstadoRevisorAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public RevisorDomain toDomainFromEntity(final RevisorEntity entity) {
		return new RevisorDomain(entity.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
				entity.getNumeroIdentificacion(), entity.getPrimerNombre(), entity.getSegundoNombre(),
				entity.getPrimerApellido(), entity.getSegundoApellido(), entity.getCorreo(), entity.getIndicadorPaisTelefono(),
				entity.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getTipoRelacion()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getTelefonoConfirmado()),
				EstadoRevisorAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<RevisorDomain> toDomainListFromEntityList(List<RevisorEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<RevisorDTO> toDtoListFromDomainList(List<RevisorDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
