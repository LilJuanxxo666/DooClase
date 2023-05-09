package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoComentarioLectorEntity;

public interface EstadoComentarioLectorDAO {

	List<EstadoComentarioLectorEntity> read(EstadoComentarioLectorEntity entity);

}
