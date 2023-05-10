package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.ComentarioLectorDomain;

public interface ComentarioLectorBusiness {
	
	void create(ComentarioLectorDomain domain);

	List<ComentarioLectorDomain> read(ComentarioLectorDomain domain);

	void update(ComentarioLectorDomain domain);

	void delete(ComentarioLectorDomain domain);

}
