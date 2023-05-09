package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public interface TipoIdentificacionDAO {
	
	List<TipoIdentificacionEntity> read(TipoIdentificacionEntity entity);
	
	void update(TipoIdentificacionEntity entity);

}