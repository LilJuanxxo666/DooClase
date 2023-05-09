package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoTipoAccesoEntity;

public interface EstadoTipoAccesoDAO {
	
	List<EstadoTipoAccesoEntity> read(EstadoTipoAccesoEntity entity);

}
