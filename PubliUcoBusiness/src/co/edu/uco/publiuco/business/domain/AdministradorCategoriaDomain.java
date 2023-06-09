package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilNumber;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class AdministradorCategoriaDomain {
	
	private static final AdministradorCategoriaDomain DEFAULT_OBJECT = new AdministradorCategoriaDomain();
	private UUID identificador;
	private TipoIdentificacionDomain tipoIdentificacion;
	private int numeroIdentificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String correo;
	private String indicadorPaisTelefono;
	private int telefono;
	private TipoRelacionInstitucionDomain relacionInstitucion;
	private RespuestaDomain correoConfirmado;
	private RespuestaDomain telefonoConfirmado;
	private EstadoAdministradorCategoriaDomain estado;
	
	private AdministradorCategoriaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoIdentificacion(TipoIdentificacionDomain.getDefaultObject());
		setNumeroIdentificacion(UtilNumber.ZERO.intValue());
		setPrimerNombre(UtilText.EMPTY);
		setSegundoNombre(UtilText.EMPTY);
		setPrimerApellido(UtilText.EMPTY);
		setSegundoApellido(UtilText.EMPTY);
		setCorreo(UtilText.EMPTY);
		setIndicadorPaisTelefono(UtilText.EMPTY);
		setTelefono(UtilNumber.ZERO.intValue());
		setRelacionInstitucion(TipoRelacionInstitucionDomain.getDefaultObject());
		setCorreoConfirmado(RespuestaDomain.getDefaultObject());
		setTelefonoConfirmado(RespuestaDomain.getDefaultObject());
		setEstado(EstadoAdministradorCategoriaDomain.getDefaultObject());
	}
	
	public AdministradorCategoriaDomain(UUID identificador, TipoIdentificacionDomain tipoIdentificacion,
			int numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String correo, String indicadorPaisTelefono, int telefono,
			TipoRelacionInstitucionDomain relacionInstitucion, RespuestaDomain correoConfirmado, RespuestaDomain telefonoConfirmado,
			EstadoAdministradorCategoriaDomain estado) {
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
	
	public static AdministradorCategoriaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = UtilObject.getDefault(tipoIdentificacion, TipoIdentificacionDomain.getDefaultObject());
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

	public final TipoRelacionInstitucionDomain getTipoRelacion() {
		return relacionInstitucion;
	}

	private final void setRelacionInstitucion(final TipoRelacionInstitucionDomain relacionInstitucion) {
		this.relacionInstitucion = UtilObject.getDefault(relacionInstitucion, TipoRelacionInstitucionDomain.getDefaultObject());
	}

	public final RespuestaDomain getCorreoConfirmado() {
		return correoConfirmado;
	}

	private final void setCorreoConfirmado(final RespuestaDomain correoConfirmado) {
		this.correoConfirmado = UtilObject.getDefault(correoConfirmado, RespuestaDomain.getDefaultObject());
	}

	public final RespuestaDomain getTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	private final void setTelefonoConfirmado(final RespuestaDomain telefonoConfirmado) {
		this.telefonoConfirmado = UtilObject.getDefault(telefonoConfirmado, RespuestaDomain.getDefaultObject());
	}

	public final EstadoAdministradorCategoriaDomain getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoAdministradorCategoriaDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoAdministradorCategoriaDomain.getDefaultObject());
	}
}
