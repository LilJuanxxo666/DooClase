package co.edu.uco.publiuco.dto;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class CategoriaDTO{
	
	private UUID identificador;
	private CategoriaDTO categoriaPadre;
	private String nombre;
	private String descripcion;
	private EstadoCategoriaDTO estadoCategoria;
	private EstadoPreferenciaDTO estadoPreferencia;
		
	public CategoriaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
		setCategoriaPadre(CategoriaDTO.create());
		setEstadoCategoria(EstadoCategoriaDTO.create());
		setEstadoPreferencia(EstadoPreferenciaDTO.create());
	}

	public CategoriaDTO(final UUID identificador, final CategoriaDTO categoriaPadre, final String nombre, final String descripcion,
			final EstadoCategoriaDTO estadoCategoria, final EstadoPreferenciaDTO estadoPreferencia) {
		super();
		setCategoriaPadre(categoriaPadre);
		setIdentificador(identificador);
		setNombre(nombre);	
		setDescripcion(descripcion);
		setEstadoCategoria(estadoCategoria);
		setEstadoPreferencia(estadoPreferencia);
	}
	public static final CategoriaDTO create(){
		return new CategoriaDTO();
	}
	public final CategoriaDTO getCategoriaPadre() {
		return categoriaPadre;
	}
	public final CategoriaDTO setCategoriaPadre(CategoriaDTO categoriaPadre) {
		this.categoriaPadre = UtilObject.getDefault(categoriaPadre, CategoriaDTO.create());
		return this;
	}
	public final UUID getIdentificador() {
		return identificador;
	}
	public final CategoriaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final CategoriaDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
	public final String getDescripcion() {
		return descripcion;
	}
	public final CategoriaDTO setDescripcion(String descripcion) {
		this.nombre = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}
	public final EstadoCategoriaDTO getEstadoCategoria() {
		return estadoCategoria;
	}
	public final CategoriaDTO setEstadoCategoria(EstadoCategoriaDTO estadoCategoria) {
		this.estadoCategoria = UtilObject.getDefault(estadoCategoria, EstadoCategoriaDTO.create());
		return this;
	}
	public final EstadoPreferenciaDTO getEstadoPreferencia() {
		return estadoPreferencia;
	}
	public final CategoriaDTO setEstadoPreferencia(EstadoPreferenciaDTO estadoPreferencia) {
		this.estadoPreferencia = UtilObject.getDefault(estadoPreferencia, EstadoPreferenciaDTO.create());
		return this;
	}
	
	
}
