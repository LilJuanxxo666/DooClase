package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoComentarioLectorDomain;

public interface EstadoComentarioLectorBusiness {

	List<EstadoComentarioLectorDomain> read(EstadoComentarioLectorDomain domain);

}
