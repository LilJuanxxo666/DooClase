package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoSuscripcionEntity;

public interface EstadoSuscripcionDAO {
	
	List<EstadoSuscripcionEntity> read(EstadoSuscripcionEntity entity);

}
