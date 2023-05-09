package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public interface TipoEscritorDAO {
	
	List<TipoEscritorEntity> read(TipoEscritorEntity entity);
	
	void update(TipoEscritorEntity entity);

}
