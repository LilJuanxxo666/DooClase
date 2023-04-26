package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class EstadoTipoRelacionInstitucionDomain {
	
	private UUID identificador;
	private String nombre;
	private String descripcion;
	
	public EstadoTipoRelacionInstitucionDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getUtilText().getDefaultValue());
		setDescripcion(UtilText.EMPTY);
	}
	
	public static EstadoTipoRelacionInstitucionDomain create() {
		return new EstadoTipoRelacionInstitucionDomain();
	}
	
	public EstadoTipoRelacionInstitucionDomain(final UUID identificador, final String nombre, final String descripcion) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	public final UUID getIdentificador() {
		return identificador;
	}
	public final EstadoTipoRelacionInstitucionDomain setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final EstadoTipoRelacionInstitucionDomain setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
	public final String getDescripcion() {
		return descripcion;
	}
	public final EstadoTipoRelacionInstitucionDomain setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	@Override
	public String toString() {
		return "EstadoTipoRelacionInstitucionDTO [identificador=" + identificador + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + "]";
	}
}