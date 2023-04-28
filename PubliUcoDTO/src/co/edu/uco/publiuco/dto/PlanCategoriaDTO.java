package co.edu.uco.publiuco.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilInteger;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class PlanCategoriaDTO {
	
	private UUID identificador;
	private CategoriaDTO categoria;
	private int precio;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private EstadoSuscripcionDTO estado;
	private EstadoSuscripcionDTO estadoCalculado;
	
	public PlanCategoriaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCategoria(CategoriaDTO.create());
		setPrecio(UtilInteger.EMPTY);
		setFechaDesde(UtilDate.DEFAULT_DATE);
		setFechaHasta(UtilDate.DEFAULT_DATE);
		setEstado(EstadoSuscripcionDTO.create());
		setEstado(EstadoSuscripcionDTO.create());
	}
	
	public PlanCategoriaDTO(UUID identificador, CategoriaDTO categoria, int precio, LocalDate fechaDesde, LocalDate fechaHasta,
			EstadoSuscripcionDTO estado, EstadoSuscripcionDTO estadoCalculado) {
		super();
		setIdentificador(identificador);
		setCategoria(categoria);
		setPrecio(precio);
		setFechaDesde(fechaDesde);
		setFechaHasta(fechaHasta);
		setEstado(estado);
		setEstado(estadoCalculado);
	}
	public static final PlanCategoriaDTO create() {
		return new PlanCategoriaDTO();
	}
	public final UUID getIdentificador() {
		return identificador;
	}
	public final PlanCategoriaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final CategoriaDTO getCategoria() {
		return categoria;
	}
	public final PlanCategoriaDTO setCategoria(CategoriaDTO categoria) {
		this.categoria = UtilObject.getDefault(categoria, CategoriaDTO.create());
		return this;
	}
	public final int getPrecio() {
		return precio;
	}
	public final PlanCategoriaDTO setPrecio(int precio) {
		this.precio = UtilInteger.getUtilInteger().getDefaultInteger(precio);
		return this;
	}
	public final LocalDate getFechaDesde() {
		return fechaDesde;
	}
	public final PlanCategoriaDTO setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = UtilDate.getDefault(fechaDesde);
		return this;
	}
	public final LocalDate getFechaHasta() {
		return fechaHasta;
	}
	public final PlanCategoriaDTO setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = UtilDate.getDefault(fechaHasta);
		return this;
	}
	public final EstadoSuscripcionDTO getEstado() {
		return estado;
	}
	public final PlanCategoriaDTO setEstado(EstadoSuscripcionDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoSuscripcionDTO.create());
		return this;
	}
	public final EstadoSuscripcionDTO getEstadoCalculado() {
		return estadoCalculado;
	}
	public final PlanCategoriaDTO setEstadoCalculado(EstadoSuscripcionDTO estadoCalculado) {
		this.estadoCalculado = UtilObject.getDefault(estadoCalculado, EstadoSuscripcionDTO.create());
		return this;
	}
	
	
}
