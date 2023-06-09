package co.edu.uco.publiuco.business.domain;

import java.util.UUID;


import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class CategoriaDomain {
	
	private static final CategoriaDomain DEFAULT_OBJECT = new CategoriaDomain();
	private UUID identificador;
	private CategoriaDomain categoriaPadre;
	private String nombre;
	private String descripcion;
	private EstadoCategoriaDomain estadoCategoria;
	private EstadoPreferenciaDomain estadoPreferencia;

	private CategoriaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCategoriaPadre(CategoriaDomain.getDefaultObject());
		setNombre(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
		setEstadoCategoria(EstadoCategoriaDomain.getDefaultObject());
		setEstadoPreferencia(EstadoPreferenciaDomain.getDefaultObject());
	}

	public CategoriaDomain(UUID identificador, CategoriaDomain categoriaPadre, String nombre, String descripcion,
			EstadoCategoriaDomain estadoCategoria, EstadoPreferenciaDomain estadoPreferencia) {
		super();
		setIdentificador(identificador);
		setCategoriaPadre(categoriaPadre);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEstadoCategoria(estadoCategoria);
		setEstadoPreferencia(estadoPreferencia);
	}
	
	public static CategoriaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final CategoriaDomain getCategoriaPadre() {
		return categoriaPadre;
	}

	private final void setCategoriaPadre(CategoriaDomain categoriaPadre) {
		this.categoriaPadre = UtilObject.getDefault(categoriaPadre, CategoriaDomain.getDefaultObject());
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
	}
	public final EstadoPreferenciaDomain getEstadoPreferencia() {
		return estadoPreferencia;
	}

	private final void setEstadoPreferencia(EstadoPreferenciaDomain estadoPreferencia) {
		this.estadoPreferencia = UtilObject.getDefault(estadoPreferencia, EstadoPreferenciaDomain.getDefaultObject());
	}
	public final EstadoCategoriaDomain getEstadoCategoria() {
		return estadoCategoria;
	}

	private final void setEstadoCategoria(EstadoCategoriaDomain estadoCategoria) {
		this.estadoCategoria = UtilObject.getDefault(estadoCategoria, EstadoCategoriaDomain.getDefaultObject());
	}
}
