package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoRevisorDomain;

public interface EstadoRevisorBusiness {
	
	List<EstadoRevisorDomain> read(EstadoRevisorDomain domain);

}
