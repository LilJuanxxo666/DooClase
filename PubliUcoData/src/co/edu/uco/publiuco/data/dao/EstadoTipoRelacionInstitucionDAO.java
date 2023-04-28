package co.edu.uco.publiuco.data.dao;

import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;
import java.util.List;

public interface EstadoTipoRelacionInstitucionDAO {
	
	void create(EstadoTipoRelacionInstitucionEntity entity);
	List<EstadoTipoRelacionInstitucionEntity> read(EstadoTipoRelacionInstitucionEntity entity);
	void update(EstadoTipoRelacionInstitucionEntity entity);
	void delete(EstadoTipoRelacionInstitucionEntity entity);
}
