package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.ObservacionRevisionDomain;

public interface ObservacionRevisionBusiness {
	
	void create(ObservacionRevisionDomain domain);

	List<ObservacionRevisionDomain> read(ObservacionRevisionDomain domain);

	void update(ObservacionRevisionDomain domain);

	void delete(ObservacionRevisionDomain domain);

}
