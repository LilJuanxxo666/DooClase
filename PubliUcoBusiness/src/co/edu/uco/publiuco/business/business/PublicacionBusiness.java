package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.PublicacionDomain;

public interface PublicacionBusiness {
	
	void create(PublicacionDomain domain);

	List<PublicacionDomain> read(PublicacionDomain domain);

	void update(PublicacionDomain domain);

	void delete(PublicacionDomain domain);

}
