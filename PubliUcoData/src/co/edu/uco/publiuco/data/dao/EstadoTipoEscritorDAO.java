package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoTipoEscritorEntity;

public interface EstadoTipoEscritorDAO {
	
	List<EstadoTipoEscritorEntity> read(EstadoTipoEscritorEntity entity);

}
