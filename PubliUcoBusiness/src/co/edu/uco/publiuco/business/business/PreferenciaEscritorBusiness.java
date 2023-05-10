package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.PreferenciaEscritorDomain;

public interface PreferenciaEscritorBusiness {
	
	void create(PreferenciaEscritorDomain domain);

	List<PreferenciaEscritorDomain> read(PreferenciaEscritorDomain domain);

	void update(PreferenciaEscritorDomain domain);

	void delete(PreferenciaEscritorDomain domain);

}
