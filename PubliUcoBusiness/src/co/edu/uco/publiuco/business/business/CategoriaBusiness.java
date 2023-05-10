package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.CategoriaDomain;

public interface CategoriaBusiness {
	
	void create(CategoriaDomain domain);

	List<CategoriaDomain> read(CategoriaDomain domain);

	void update(CategoriaDomain domain);

	void delete(CategoriaDomain domain);

}
