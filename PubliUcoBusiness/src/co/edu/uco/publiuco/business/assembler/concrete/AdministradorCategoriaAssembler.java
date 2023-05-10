package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;

public final class AdministradorCategoriaAssembler
		implements Assembler<AdministradorCategoriaDomain, AdministradorCategoriaDTO, AdministradorCategoriaEntity> {

	private static final Assembler<AdministradorCategoriaDomain, AdministradorCategoriaDTO, AdministradorCategoriaEntity> INSTANCE = new AdministradorCategoriaAssembler();

	private AdministradorCategoriaAssembler() {
		super();
	}

	public static Assembler<AdministradorCategoriaDomain, AdministradorCategoriaDTO, AdministradorCategoriaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public AdministradorCategoriaDTO toDtoFromDomain(final AdministradorCategoriaDomain domain) {
		return AdministradorCategoriaDTO.create().setIdentificador(domain.getIdentificador()).
				setTipoIdentifiacion(TipoIdentificacionAssembler.getInstance().toDtoFromDomain(domain.getTipoIdentificacion())).
				setNumeroIdentificacion(domain.getNumeroIdentificacion()).setPrimerNombre(domain.getPrimerNombre()).setSegundoNombre(domain.getSegundoNombre()).
				setPrimerApellido(domain.getPrimerApellido()).setSegundoApellido(domain.getSegundoApellido()).
				setCorreo(domain.getCorreo()).setIndicadorPaisTelefono(domain.getIndicadorPaisTelefono()).setTelefono(domain.getTelefono()).
				setRelacionInstitucion(TipoRelacionInstitucionAssembler.getInstance().toDtoFromDomain(domain.getTipoRelacion())).
				setCorreoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getCorreoConfirmado())).
				setTelefonoConfirmado(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getTelefonoConfirmado())).
				setEstado(EstadoAdministradorCategoriaAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public AdministradorCategoriaDomain toDomainFromDto(final AdministradorCategoriaDTO dto) {
		return new AdministradorCategoriaDomain(dto.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentifiacion()),
				dto.getNumeroIdentificacion(), dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(),
				dto.getSegundoApellido(), dto.getCorreo(), dto.getIndicadorPaisTelefono(), dto.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto.getRelacionInstitucion()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getTelefonoConfirmado()),
				EstadoAdministradorCategoriaAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public AdministradorCategoriaEntity toEntityFromDomain(final AdministradorCategoriaDomain domain) {
		return new AdministradorCategoriaEntity(domain.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),
				domain.getNumeroIdentificacion(), domain.getPrimerNombre(), domain.getSegundoNombre(),
				domain.getPrimerApellido(), domain.getSegundoApellido(), domain.getCorreo(), domain.getIndicadorPaisTelefono(),
				domain.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getTipoRelacion()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getTelefonoConfirmado()),
				EstadoAdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public AdministradorCategoriaDomain toDomainFromEntity(final AdministradorCategoriaEntity entity) {
		return new AdministradorCategoriaDomain(entity.getIdentificador(),
				TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
				entity.getNumeroIdentificacion(), entity.getPrimerNombre(), entity.getSegundoNombre(),
				entity.getPrimerApellido(), entity.getSegundoApellido(), entity.getCorreo(), entity.getIndicadorPaisTelefono(),
				entity.getTelefono(),
				TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getTipoRelacion()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getCorreoConfirmado()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getTelefonoConfirmado()),
				EstadoAdministradorCategoriaAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<AdministradorCategoriaDomain> toDomainListFromEntityList(List<AdministradorCategoriaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<AdministradorCategoriaDTO> toDtoListFromDomainList(List<AdministradorCategoriaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}
