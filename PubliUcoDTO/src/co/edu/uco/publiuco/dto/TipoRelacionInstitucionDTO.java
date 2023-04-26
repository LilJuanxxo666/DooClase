package co.edu.uco.publiuco.dto;

import java.util.UUID;

public class TipoRelacionInstitucionDTO {
	private UUID identificador; 
	private String nombre;
	private String descripcion;
	private EstadoTipoRelacionInstitucionDTO estado;
	
	public TipoRelacionInstitucionDTO(UUID identificador, String nombre, String descripcion,
			EstadoTipoRelacionInstitucionDTO estado) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public TipoRelacionInstitucionDTO() {
		super();
	}

	public UUID getIdentificador() {
		return identificador;
	}
	public void setIdentificador(UUID identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EstadoTipoRelacionInstitucionDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoTipoRelacionInstitucionDTO estado) {
		this.estado = estado;
	}
	
	

}