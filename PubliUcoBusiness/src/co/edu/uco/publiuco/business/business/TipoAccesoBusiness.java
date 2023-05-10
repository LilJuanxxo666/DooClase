package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.TipoAccesoDomain;

public interface TipoAccesoBusiness {
	
	void create(TipoAccesoDomain domain);

	List<TipoAccesoDomain> read(TipoAccesoDomain domain);
	
	void update(TipoAccesoDomain domain);

	void delete(TipoAccesoDomain domain);

}
