package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.CategoriaAdministradorCategoriaDomain;

public interface CategoriaAdministradorCategoriaBusiness {
	
	void create(CategoriaAdministradorCategoriaDomain domain);

	List<CategoriaAdministradorCategoriaDomain> read(CategoriaAdministradorCategoriaDomain domain);

	void update(CategoriaAdministradorCategoriaDomain domain);

	void delete(CategoriaAdministradorCategoriaDomain domain);

}
