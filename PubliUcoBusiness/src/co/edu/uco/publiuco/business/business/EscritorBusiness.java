package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EscritorDomain;

public interface EscritorBusiness {
	
	void create(EscritorDomain domain);

	List<EscritorDomain> read(EscritorDomain domain);

	void update(EscritorDomain domain);

	void delete(EscritorDomain domain);

}
