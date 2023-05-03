package co.edu.uco.publiuco.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilNumber;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class PlanCategoriaDomain {
	
	private static final PlanCategoriaDomain DEFAULT_OBJECT = new PlanCategoriaDomain();
	private UUID identificador;
	private CategoriaDomain categoria;
	private double precio;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private EstadoSuscripcionDomain estado;
	
	private PlanCategoriaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCategoria(CategoriaDomain.getDefaultObject());
		setPrecio(UtilNumber.ZERO.doubleValue());
		setFechaDesde(UtilDate.DEFAULT_DATE);
		setFechaHasta(UtilDate.DEFAULT_DATE);
		setEstado(EstadoSuscripcionDomain.getDefaultObject());
	}

	public PlanCategoriaDomain(UUID identificador, CategoriaDomain categoria, double precio, LocalDate fechaDesde,
			LocalDate fechaHasta, EstadoSuscripcionDomain estado) {
		super();
		setIdentificador(identificador);
		setCategoria(categoria);
		setPrecio(precio);
		setFechaDesde(fechaDesde);
		setFechaHasta(fechaHasta);
		setEstado(estado);
	}
	public static PlanCategoriaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final CategoriaDomain getCategoria() {
		return categoria;
	}

	private final void setCategoria(final CategoriaDomain categoria) {
		this.categoria = UtilObject.getDefault(categoria, CategoriaDomain.getDefaultObject());
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
	
	public final EstadoSuscripcionDomain getEstado() {
		return estado;
	}

	private final void setEstado(EstadoSuscripcionDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoSuscripcionDomain.getDefaultObject());
	}
}
