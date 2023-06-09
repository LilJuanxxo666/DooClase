package co.edu.uco.publiuco.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilNumber;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class PlanPublicacionEntity {

	private static final PlanPublicacionEntity DEFAULT_OBJECT = new PlanPublicacionEntity();
	private UUID identificador;
	private PublicacionEntity publicacion;
	private double precio;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;

	private PlanPublicacionEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setPublicacion(PublicacionEntity.getDefaultObject());
		setPrecio(UtilNumber.ZERO.doubleValue());
		setFechaDesde(UtilDate.DEFAULT_DATE);
		setFechaHasta(UtilDate.DEFAULT_DATE);
	}

	public PlanPublicacionEntity(UUID identificador, PublicacionEntity publicacion, double precio, LocalDate fechaDesde,
			LocalDate fechaHasta) {
		super();
		setIdentificador(identificador);
		setPublicacion(publicacion);
		setPrecio(precio);
		setFechaDesde(fechaDesde);
		setFechaHasta(fechaHasta);
	}

	public static PlanPublicacionEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final PublicacionEntity getPublicacion() {
		return publicacion;
	}

	private final void setPublicacion(final PublicacionEntity publicacion) {
		this.publicacion = UtilObject.getDefault(publicacion, PublicacionEntity.getDefaultObject());
	}

	public final double getPrecio() {
		return precio;
	}

	private final void setPrecio(final double precio) {
		this.precio = UtilNumber.getUtilNumber().getDefault(precio).doubleValue();
	}

	public final LocalDate getFechaDesde() {
		return fechaDesde;
	}

	private final void setFechaDesde(final LocalDate fechaDesde) {
		this.fechaDesde = UtilDate.getDefault(fechaDesde);
	}

	public final LocalDate getFechaHasta() {
		return fechaHasta;
	}

	private final void setFechaHasta(final LocalDate fechaHasta) {
		this.fechaHasta = UtilDate.getDefault(fechaHasta);
	}
}
