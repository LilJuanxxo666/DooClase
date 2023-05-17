package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoVersionDomain;

public interface EstadoVersionBusiness {
	
	List<EstadoVersionDomain> list(EstadoVersionDomain domain);

}
