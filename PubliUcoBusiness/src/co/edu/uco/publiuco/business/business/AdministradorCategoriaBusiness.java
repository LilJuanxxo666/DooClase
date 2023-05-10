package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.AdministradorCategoriaDomain;

public interface AdministradorCategoriaBusiness {

	void create(AdministradorCategoriaDomain domain);

	List<AdministradorCategoriaDomain> read(AdministradorCategoriaDomain domain);

	void update(AdministradorCategoriaDomain domain);

	void delete(AdministradorCategoriaDomain domain);

}
