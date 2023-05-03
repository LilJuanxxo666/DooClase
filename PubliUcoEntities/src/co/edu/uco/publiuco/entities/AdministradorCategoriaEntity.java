package co.edu.uco.publiuco.entities;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilNumber;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class AdministradorCategoriaEntity {
	
	private static final AdministradorCategoriaEntity DEFAULT_OBJECT = new AdministradorCategoriaEntity();
	private UUID identificador;
	private TipoIdentificacionEntity tipoIdentificacion;
	private int numeroIdentificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String correo;
	private String indicadorPaisTelefono;
	private int telefono;
	private TipoRelacionInstitucionEntity relacionInstitucion;
	private RespuestaEntity correoConfirmado;
	private RespuestaEntity telefonoConfirmado;
	private EstadoAdministradorCategoriaEntity estado;
	
	private AdministradorCategoriaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoIdentificacion(TipoIdentificacionEntity.getDefaultObject());
		setNumeroIdentificacion(UtilNumber.ZERO.intValue());
		setPrimerNombre(UtilText.EMPTY);
		setSegundoNombre(UtilText.EMPTY);
		setPrimerApellido(UtilText.EMPTY);
		setSegundoApellido(UtilText.EMPTY);
		setCorreo(UtilText.EMPTY);
		setIndicadorPaisTelefono(UtilText.EMPTY);
		setTelefono(UtilNumber.ZERO.intValue());
		setRelacionInstitucion(TipoRelacionInstitucionEntity.getDefaultObject());
		setCorreoConfirmado(RespuestaEntity.getDefaultObject());
		setTelefonoConfirmado(RespuestaEntity.getDefaultObject());
		setEstado(EstadoAdministradorCategoriaEntity.getDefaultObject());
	}
	
	public AdministradorCategoriaEntity(UUID identificador, TipoIdentificacionEntity tipoIdentificacion,
			int numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String correo, String indicadorPaisTelefono, int telefono,
			TipoRelacionInstitucionEntity relacionInstitucion, RespuestaEntity correoConfirmado, RespuestaEntity telefonoConfirmado,
			EstadoAdministradorCategoriaEntity estado) {
		super();
		setIdentificador(identificador);
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		setCorreo(correo);
		setIndicadorPaisTelefono(indicadorPaisTelefono);
		setTelefono(telefono);
		setRelacionInstitucion(relacionInstitucion);
		setCorreoConfirmado(correoConfirmado);
		setTelefonoConfirmado(telefonoConfirmado);
		setEstado(estado);
	}
	
	public static AdministradorCategoriaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = UtilObject.getDefault(tipoIdentificacion, TipoIdentificacionEntity.getDefaultObject());
	}

	public final int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	private final void setNumeroIdentificacion(final int numeroIdentificacion) {
		this.numeroIdentificacion = UtilNumber.getUtilNumber().getDefault(numeroIdentificacion).intValue();
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	private final void setPrimerNombre(final String primerNombre) {
		this.primerNombre = UtilText.getUtilText().applyTrim(primerNombre);
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	private final void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = UtilText.getUtilText().applyTrim(segundoNombre);
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	private final void setPrimerApellido(final String primerApellido) {
		this.primerApellido = UtilText.getUtilText().applyTrim(primerApellido);
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	private final void setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = UtilText.getUtilText().applyTrim(segundoApellido);
	}

	public final String getCorreo() {
		return correo;
	}

	private final void setCorreo(final String correo) {
		this.correo = UtilText.getDefaultStringEmail(correo);
	}

	public final String getIndicadorPaisTelefono() {
		return indicadorPaisTelefono;
	}

	private final void setIndicadorPaisTelefono(final String indicadorPaisTelefono) {
		this.indicadorPaisTelefono = UtilText.getUtilText().applyTrim(indicadorPaisTelefono);
	}

	public final int getTelefono() {
		return telefono;
	}

	private final void setTelefono(final int telefono) {
		this.telefono = UtilNumber.getUtilNumber().getDefault(telefono).intValue();
	}

	public final TipoRelacionInstitucionEntity getTipoRelacion() {
		return relacionInstitucion;
	}

	private final void setRelacionInstitucion(final TipoRelacionInstitucionEntity relacionInstitucion) {
		this.relacionInstitucion = UtilObject.getDefault(relacionInstitucion, TipoRelacionInstitucionEntity.getDefaultObject());
	}

	public final RespuestaEntity getCorreoConfirmado() {
		return correoConfirmado;
	}

	private final void setCorreoConfirmado(final RespuestaEntity correoConfirmado) {
		this.correoConfirmado = UtilObject.getDefault(correoConfirmado, RespuestaEntity.getDefaultObject());
	}

	public final RespuestaEntity getTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	private final void setTelefonoConfirmado(final RespuestaEntity telefonoConfirmado) {
		this.telefonoConfirmado = UtilObject.getDefault(telefonoConfirmado, RespuestaEntity.getDefaultObject());
	}

	public final EstadoAdministradorCategoriaEntity getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoAdministradorCategoriaEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoAdministradorCategoriaEntity.getDefaultObject());
	}
}
