package co.edu.uco.publiuco.dto;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class SuscripcionCategoriaDTO {
	
	private UUID identificador;
	private PerfilDTO perfil;
	private PlanCategoriaDTO planCategoria;
	private EstadoSuscripcionDTO estado;
	
	public SuscripcionCategoriaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setPerfil(PerfilDTO.create());
		setPlanCategoria(PlanCategoriaDTO.create());
		setEstado(EstadoSuscripcionDTO.create());
	}
	
	public SuscripcionCategoriaDTO(UUID identificador, PerfilDTO perfil, PlanCategoriaDTO planCategoria,
			EstadoSuscripcionDTO estado) {
		super();
		setIdentificador(identificador);
		setPerfil(perfil);
		setPlanCategoria(planCategoria);
		setEstado(estado);
	}
	public static final SuscripcionCategoriaDTO create() {
		return new SuscripcionCategoriaDTO();
	}
	public final UUID getIdentificador() {
		return identificador;
	}
	public final SuscripcionCategoriaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final PerfilDTO getPerfil() {
		return perfil;
	}
	public final SuscripcionCategoriaDTO setPerfil(PerfilDTO perfil) {
		this.perfil = UtilObject.getDefault(perfil, PerfilDTO.create());
		return this;
	}
	public final PlanCategoriaDTO getPlanCategoria() {
		return planCategoria;
	}
	public final SuscripcionCategoriaDTO setPlanCategoria(PlanCategoriaDTO planCategoria) {
		this.planCategoria = UtilObject.getDefault(planCategoria, PlanCategoriaDTO.create());
		return this;
	}
	public final EstadoSuscripcionDTO getEstado() {
		return estado;
	}
	public final SuscripcionCategoriaDTO setEstado(EstadoSuscripcionDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoSuscripcionDTO.create());
		return this;
	}
}
