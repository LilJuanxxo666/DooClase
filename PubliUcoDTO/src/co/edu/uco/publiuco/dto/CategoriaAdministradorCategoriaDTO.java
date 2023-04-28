package co.edu.uco.publiuco.dto;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class CategoriaAdministradorCategoriaDTO{
	
	private UUID identificador;
	private CategoriaDTO categoria;
	private AdministradorCategoriaDTO administradorCategoria;
	private EstadoCategoriaDTO estado;
	
	public CategoriaAdministradorCategoriaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCategoria(CategoriaDTO.create());
		setAdministradorCategoria(AdministradorCategoriaDTO.create());
		setEstado(EstadoCategoriaDTO.create());
	}
	public CategoriaAdministradorCategoriaDTO(UUID identificador, CategoriaDTO categoria,
			AdministradorCategoriaDTO administradorCategoria, EstadoCategoriaDTO estado) {
		super();
		setIdentificador(identificador);
		setCategoria(categoria);
		setAdministradorCategoria(administradorCategoria);
		setEstado(estado);
	}
	public static final CategoriaAdministradorCategoriaDTO create() {
		return new CategoriaAdministradorCategoriaDTO();
	}
	public final UUID getIdentificador() {
		return identificador;
	}
	public final CategoriaAdministradorCategoriaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final CategoriaDTO getCategoria() {
		return categoria;
	}
	public final CategoriaAdministradorCategoriaDTO setCategoria(CategoriaDTO categoria) {
		this.categoria = UtilObject.getDefault(categoria, CategoriaDTO.create());
		return this;
	}
	public final AdministradorCategoriaDTO getAdministradorCategoria() {
		return administradorCategoria;
	}
	public final CategoriaAdministradorCategoriaDTO setAdministradorCategoria(AdministradorCategoriaDTO administradorCategoria) {
		this.administradorCategoria = UtilObject.getDefault(administradorCategoria, AdministradorCategoriaDTO.create());
		return this;
	}
	public final EstadoCategoriaDTO getEstado() {
		return estado;
	}
	public final CategoriaAdministradorCategoriaDTO setEstado(EstadoCategoriaDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoCategoriaDTO.create());
		return this;
	}
	
	
}
