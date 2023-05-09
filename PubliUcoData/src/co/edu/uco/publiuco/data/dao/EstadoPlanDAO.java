package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoPlanEntity;

public interface EstadoPlanDAO {

	List<EstadoPlanEntity> read(EstadoPlanEntity entity);

}
