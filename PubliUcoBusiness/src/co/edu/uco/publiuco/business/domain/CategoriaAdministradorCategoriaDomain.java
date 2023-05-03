package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class CategoriaAdministradorCategoriaDomain {
	
	private static final CategoriaAdministradorCategoriaDomain DEFAULT_OBJECT = new CategoriaAdministradorCategoriaDomain();
	private UUID identificador;
	private CategoriaDomain categoria;
	private AdministradorCategoriaDomain administradorCategoria;
	private EstadoCategoriaDomain estado;

	private CategoriaAdministradorCategoriaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCategoria(CategoriaDomain.getDefaultObject());
		setAdministradorCategoria(AdministradorCategoriaDomain.getDefaultObject());
		setEstado(EstadoCategoriaDomain.getDefaultObject());
	}

	public CategoriaAdministradorCategoriaDomain(UUID identificador, CategoriaDomain categoria,
			AdministradorCategoriaDomain administradorCategoria, EstadoCategoriaDomain estado) {
		super();
		setIdentificador(identificador);
		setCategoria(categoria);
		setAdministradorCategoria(administradorCategoria);
		setEstado(estado);
	}
	
	public static CategoriaAdministradorCategoriaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final CategoriaDomain getCategoria() {
		return categoria;
	}

	private final void setCategoria(CategoriaDomain categoria) {
		this.categoria = UtilObject.getDefault(categoria, CategoriaDomain.getDefaultObject());
	}

	public final AdministradorCategoriaDomain getAdministradorCategoria() {
		return administradorCategoria;
	}

	private final void setAdministradorCategoria(AdministradorCategoriaDomain administradorCategoria) {
		this.administradorCategoria = UtilObject.getDefault(administradorCategoria, AdministradorCategoriaDomain.getDefaultObject());
	}

	public final EstadoCategoriaDomain getEstado() {
		return estado;
	}

	private final void setEstado(EstadoCategoriaDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoCategoriaDomain.getDefaultObject());
	}
}
