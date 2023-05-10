package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.LectorDomain;

public interface LectorBusiness {
	
	void create(LectorDomain domain);

	List<LectorDomain> read(LectorDomain domain);

	void update(LectorDomain domain);

	void delete(LectorDomain entity);

}
