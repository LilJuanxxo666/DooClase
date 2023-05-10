package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoObservacionRevisorDomain;

public interface EstadoObservacionRevisorBusiness {

	List<EstadoObservacionRevisorDomain> read(EstadoObservacionRevisorDomain domain);

}
