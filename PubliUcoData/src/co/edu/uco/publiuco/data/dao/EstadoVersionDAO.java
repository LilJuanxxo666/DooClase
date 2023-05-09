package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoVersionEntity;

public interface EstadoVersionDAO {
	
	List<EstadoVersionEntity> read(EstadoVersionEntity entity);

}
