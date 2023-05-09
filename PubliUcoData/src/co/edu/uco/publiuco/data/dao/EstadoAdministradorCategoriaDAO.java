package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoAdministradorCategoriaEntity;

public interface EstadoAdministradorCategoriaDAO {
	
	List<EstadoAdministradorCategoriaEntity> read(EstadoAdministradorCategoriaEntity entity);

}
