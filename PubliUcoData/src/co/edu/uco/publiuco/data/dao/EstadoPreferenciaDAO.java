package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoPreferenciaEntity;

public interface EstadoPreferenciaDAO {
	
	List<EstadoPreferenciaEntity> read(EstadoPreferenciaEntity entity);

}
