package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.SuscripcionPublicacionDomain;

public interface SuscripcionPublicacionBusiness {
	
	void create(SuscripcionPublicacionDomain domain);

	List<SuscripcionPublicacionDomain> read(SuscripcionPublicacionDomain domain);

	void update(SuscripcionPublicacionDomain domain);

	void delete(SuscripcionPublicacionDomain domain);

}
