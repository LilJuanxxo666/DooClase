package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoTipoAccesoDomain;

public interface EstadoTipoAccesoBusiness {
	
	List<EstadoTipoAccesoDomain> read(EstadoTipoAccesoDomain domain);

}
