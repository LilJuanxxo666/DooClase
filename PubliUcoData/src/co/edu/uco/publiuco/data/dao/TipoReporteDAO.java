package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.TipoReporteEntity;

public interface TipoReporteDAO {
	
	List<TipoReporteEntity> read(TipoReporteEntity entity);

}