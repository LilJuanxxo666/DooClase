package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EscritorPublicacionDomain;

public interface EscritorPublicacionBusiness {
	
	void create(EscritorPublicacionDomain domain);

	List<EscritorPublicacionDomain> read(EscritorPublicacionDomain domain);

	void update(EscritorPublicacionDomain domain);

	void delete(EscritorPublicacionDomain domain);

}