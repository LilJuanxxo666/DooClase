package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.CalificacionDomain;

public interface CalificacionBusiness {
	
	void create(CalificacionDomain domain);

	List<CalificacionDomain> read(CalificacionDomain domain);

	void update(CalificacionDomain domain);

	void delete(CalificacionDomain domain);

}
