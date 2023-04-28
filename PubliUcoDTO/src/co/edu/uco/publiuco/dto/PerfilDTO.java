package co.edu.uco.publiuco.dto;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class PerfilDTO {
	private UUID identificador;
	private LectorDTO lector;
	private RespuestaDTO recomendacionCategoria;
	private RespuestaDTO recomendacionAutor;
	private EstadoLectorDTO estado;
	
	public PerfilDTO(UUID identificador, LectorDTO lector, RespuestaDTO recomendacionCategoria,
			RespuestaDTO recomendacionAutor, EstadoLectorDTO estado) {
		super();
		setIdentificador(identificador);
		setLector(lector);
		setRecomendacionAutor(recomendacionAutor);
		setRecomendacionCategoria(recomendacionCategoria);
		setEstado(estado);
	}
	
	public PerfilDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setLector(LectorDTO.create());
		setRecomendacionAutor(RespuestaDTO.create());
		setRecomendacionCategoria(RespuestaDTO.create());
		setEstado(EstadoLectorDTO.create());
	}
	
	public static final PerfilDTO create() {
		return new PerfilDTO();
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	public final PerfilDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final LectorDTO getLector() {
		return lector;
	}
	public final PerfilDTO setLector(LectorDTO lector) {
		this.lector = UtilObject.getDefault(lector, LectorDTO.create());
		return this;
	}
	public final RespuestaDTO getRecomendacionCategoria() {
		return recomendacionCategoria;
	}
	public final PerfilDTO setRecomendacionCategoria(RespuestaDTO recomendacionCategoria) {
		this.recomendacionCategoria = UtilObject.getDefault(recomendacionCategoria, RespuestaDTO.create());
		return this;
	}
	public final RespuestaDTO getRecomendacionAutor() {
		return recomendacionAutor;
	}
	public final PerfilDTO setRecomendacionAutor(RespuestaDTO recomendacionAutor) {
		this.recomendacionAutor = UtilObject.getDefault(recomendacionAutor, RespuestaDTO.create());
		return this;
	}
	public final EstadoLectorDTO getEstado() {
		return estado;
	}
	public final PerfilDTO setEstado(EstadoLectorDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoLectorDTO.create());
		return this;
	}
	
	
}

