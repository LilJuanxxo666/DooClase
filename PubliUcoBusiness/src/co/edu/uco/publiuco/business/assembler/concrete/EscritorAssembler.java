package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EscritorDomain;
import co.edu.uco.publiuco.dto.EscritorDTO;
import co.edu.uco.publiuco.entities.EscritorEntity;

public final class EscritorAssembler implements Assembler<EscritorDomain, EscritorDTO, EscritorEntity>{
	
	private static final Assembler<EscritorDomain, EscritorDTO, EscritorEntity> INSTANCE = new EscritorAssembler();

	private EscritorAssembler() {
		super();
	}

	public static Assembler<EscritorDomain, EscritorDTO, EscritorEntity> getInstance() {
		return INSTANCE;
	}
	
	@Override
	public EscritorDTO toDtoFromDomain(final EscritorDomain domain) {
		return EscritorDTO.create().setIdentificador(domain.getIdentificador()).
				setTipoIdentifiacion(TipoIdentificacionAssembler.getInstance().toDtoFromDomain(domain.getTipoIdentificacion())).
				setPrimerNombre(domain.getPrimerNombre()).setSegundoNombre(domain.getSegundoNombre()).setPrimerApellido(domain.getPrimerApellido()).
				setSegundoApellido(domain.getSegundoApellido()).setCorreo(domain.getCorreo()).setIndicadorPaisTelefono(domain.getIndicadorPaisTelefono()).
				setTelefono(domain.getTelefono()).setRelacionInstitucion(TipoRelacionInstitucionAssembler.getInstance().toDtoFromDomain(domain.getTipoRelacion())).
				setCorreoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getCorreoConfirmado())).
				setTelefonoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getTelefonoConfirmado())).
				setEstado(EstadoEscritorAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public EscritorDomain toDomainFromDto(final EscritorDTO dto) {
		return new EscritorDomain(dto.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentifiacion()),
				dto.getNumeroIdentificacion(), dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(),
				dto.getSegundoApellido(), dto.getCorreo(), dto.getIndicadorPaisTelefono(), dto.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto.getRelacionInstitucion()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getTelefonoConfirmado()),
				EstadoEscritorAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public EscritorEntity toEntityFromDomain(final EscritorDomain domain) {
		return new EscritorEntity(domain.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),
				domain.getNumeroIdentificacion(), domain.getPrimerNombre(), domain.getSegundoNombre(),
				domain.getPrimerApellido(), domain.getSegundoApellido(), domain.getCorreo(), domain.getIndicadorPaisTelefono(),
				domain.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getTipoRelacion()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getTelefonoConfirmado()),
				EstadoEscritorAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public EscritorDomain toDomainFromEntity(final EscritorEntity entity) {
		return new EscritorDomain(entity.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
				entity.getNumeroIdentificacion(), entity.getPrimerNombre(), entity.getSegundoNombre(),
				entity.getPrimerApellido(), entity.getSegundoApellido(), entity.getCorreo(), entity.getIndicadorPaisTelefono(),
				entity.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getTipoRelacion()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getTelefonoConfirmado()),
				EstadoEscritorAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}
}

