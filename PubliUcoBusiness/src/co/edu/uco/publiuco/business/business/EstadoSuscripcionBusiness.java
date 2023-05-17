package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoSuscripcionDomain;

public interface EstadoSuscripcionBusiness {
	
	List<EstadoSuscripcionDomain> list(EstadoSuscripcionDomain domain);

}
