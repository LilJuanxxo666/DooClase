package co.edu.uco.publiuco.entities;

import java.util.UUID;


import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class CategoriaEntity {
	
	private static final CategoriaEntity DEFAULT_OBJECT = new CategoriaEntity();
	private UUID identificador;
	private CategoriaEntity categoriaPadre;
	private String nombre;
	private String descripcion;
	private EstadoCategoriaEntity estadoCategoria;
	private EstadoPreferenciaEntity estadoPreferencia;

	private CategoriaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCategoriaPadre(CategoriaEntity.getDefaultObject());
		setNombre(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
		setEstadoCategoria(EstadoCategoriaEntity.getDefaultObject());
		setEstadoPreferencia(EstadoPreferenciaEntity.getDefaultObject());
	}

	public CategoriaEntity(UUID identificador, CategoriaEntity categoriaPadre, String nombre, String descripcion,
			EstadoCategoriaEntity estadoCategoria, EstadoPreferenciaEntity estadoPreferencia) {
		super();
		setIdentificador(identificador);
		setCategoriaPadre(categoriaPadre);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEstadoCategoria(estadoCategoria);
		setEstadoPreferencia(estadoPreferencia);
	}
	
	public static CategoriaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final CategoriaEntity getCategoriaPadre() {
		return categoriaPadre;
	}

	private final void setCategoriaPadre(CategoriaEntity categoriaPadre) {
		this.categoriaPadre = UtilObject.getDefault(categoriaPadre, CategoriaEntity.getDefaultObject());
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
	public final EstadoPreferenciaEntity getEstadoPreferencia() {
		return estadoPreferencia;
	}

	private final void setEstadoPreferencia(EstadoPreferenciaEntity estadoPreferencia) {
		this.estadoPreferencia = UtilObject.getDefault(estadoPreferencia, EstadoPreferenciaEntity.getDefaultObject());
	}
	public final EstadoCategoriaEntity getEstadoCategoria() {
		return estadoCategoria;
	}

	private final void setEstadoCategoria(EstadoCategoriaEntity estadoCategoria) {
		this.estadoCategoria = UtilObject.getDefault(estadoCategoria, EstadoCategoriaEntity.getDefaultObject());
	}
}
