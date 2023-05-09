package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoRevisionEntity;

public interface EstadoRevisionDAO {
	
	List<EstadoRevisionEntity> read(EstadoRevisionEntity entity);

}
