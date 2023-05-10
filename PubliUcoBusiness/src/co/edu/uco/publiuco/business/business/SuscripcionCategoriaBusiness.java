package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.SuscripcionCategoriaDomain;

public interface SuscripcionCategoriaBusiness {
	
	void create(SuscripcionCategoriaDomain domain);

	List<SuscripcionCategoriaDomain> read(SuscripcionCategoriaDomain domain);

	void update(SuscripcionCategoriaDomain domain);

	void delete(SuscripcionCategoriaDomain domain);

}