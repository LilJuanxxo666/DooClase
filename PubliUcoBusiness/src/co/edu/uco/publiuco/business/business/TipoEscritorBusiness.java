package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.TipoEscritorDomain;

public interface TipoEscritorBusiness {
	
	List<TipoEscritorDomain> read(TipoEscritorDomain domain);
	
	void update(TipoEscritorDomain domain);

}
