package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.PreferenciaCategoriaDomain;

public interface PreferenciaCategoriaBusiness {
	
	void create(PreferenciaCategoriaDomain domain);

	List<PreferenciaCategoriaDomain> read(PreferenciaCategoriaDomain domain);

	void update(PreferenciaCategoriaDomain domain);

	void delete(PreferenciaCategoriaDomain domain);

}
