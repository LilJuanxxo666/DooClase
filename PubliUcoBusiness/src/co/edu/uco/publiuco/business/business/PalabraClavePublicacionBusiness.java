package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.PalabraClavePublicacionDomain;

public interface PalabraClavePublicacionBusiness {
	
	void create(PalabraClavePublicacionDomain domain);

	List<PalabraClavePublicacionDomain> read(PalabraClavePublicacionDomain domain);

	void update(PalabraClavePublicacionDomain domain);

	void delete(PalabraClavePublicacionDomain domain);

}
