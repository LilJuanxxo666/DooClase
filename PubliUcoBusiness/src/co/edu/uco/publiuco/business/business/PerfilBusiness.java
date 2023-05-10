package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.PerfilDomain;

public interface PerfilBusiness {
	
	void create(PerfilDomain domain);

	List<PerfilDomain> read(PerfilDomain domain);

	void update(PerfilDomain domain);

	void delete(PerfilDomain domain);

}
