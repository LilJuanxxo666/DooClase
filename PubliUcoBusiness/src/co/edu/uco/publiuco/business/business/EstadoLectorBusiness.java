package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoLectorDomain;

public interface EstadoLectorBusiness {

	List<EstadoLectorDomain> list(EstadoLectorDomain domain);

}
