package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class SuscripcionCategoriaDomain {

	private static final SuscripcionCategoriaDomain DEFAULT_OBJECT = new SuscripcionCategoriaDomain();
	private UUID identificador;
	private PerfilDomain perfil;
	private PlanCategoriaDomain planCategoria;
	private EstadoSuscripcionDomain estado;

	private SuscripcionCategoriaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setPerfil(PerfilDomain.getDefaultObject());
		setPlanCategoria(PlanCategoriaDomain.getDefaultObject());
		setEstado(EstadoSuscripcionDomain.getDefaultObject());
	}

	public SuscripcionCategoriaDomain(UUID identificador, PerfilDomain perfil, PlanCategoriaDomain planCategoria,
			EstadoSuscripcionDomain estado) {
		super();
		setIdentificador(identificador);
		setPerfil(perfil);
		setPlanCategoria(planCategoria);
		setEstado(estado);
	}

	public static SuscripcionCategoriaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final PerfilDomain getPerfil() {
		return perfil;
	}

	private final void setPerfil(final PerfilDomain perfil) {
		this.perfil = UtilObject.getDefault(perfil, PerfilDomain.getDefaultObject());
	}

	public final PlanCategoriaDomain getPlanCategoria() {
		return planCategoria;
	}

	private final void setPlanCategoria(final PlanCategoriaDomain planCategoria) {
		this.planCategoria = UtilObject.getDefault(planCategoria, PlanCategoriaDomain.getDefaultObject());
	}

	public final EstadoSuscripcionDomain getEstado() {
		return estado;
	}

	private final void setEstado(EstadoSuscripcionDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoSuscripcionDomain.getDefaultObject());
	}
	
}
