package co.edu.uco.publiuco.entities;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class SuscripcionCategoriaEntity {

	private static final SuscripcionCategoriaEntity DEFAULT_OBJECT = new SuscripcionCategoriaEntity();
	private UUID identificador;
	private PerfilEntity perfil;
	private PlanCategoriaEntity planCategoria;
	private EstadoSuscripcionEntity estado;

	private SuscripcionCategoriaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setPerfil(PerfilEntity.getDefaultObject());
		setPlanCategoria(PlanCategoriaEntity.getDefaultObject());
		setEstado(EstadoSuscripcionEntity.getDefaultObject());
	}

	public SuscripcionCategoriaEntity(UUID identificador, PerfilEntity perfil, PlanCategoriaEntity planCategoria,
			EstadoSuscripcionEntity estado) {
		super();
		setIdentificador(identificador);
		setPerfil(perfil);
		setPlanCategoria(planCategoria);
		setEstado(estado);
	}

	public static SuscripcionCategoriaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final PerfilEntity getPerfil() {
		return perfil;
	}

	private final void setPerfil(final PerfilEntity perfil) {
		this.perfil = UtilObject.getDefault(perfil, PerfilEntity.getDefaultObject());
	}

	public final PlanCategoriaEntity getPlanCategoria() {
		return planCategoria;
	}

	private final void setPlanCategoria(final PlanCategoriaEntity planCategoria) {
		this.planCategoria = UtilObject.getDefault(planCategoria, PlanCategoriaEntity.getDefaultObject());
	}

	public final EstadoSuscripcionEntity getEstado() {
		return estado;
	}

	private final void setEstado(EstadoSuscripcionEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoSuscripcionEntity.getDefaultObject());
	}
	
}
