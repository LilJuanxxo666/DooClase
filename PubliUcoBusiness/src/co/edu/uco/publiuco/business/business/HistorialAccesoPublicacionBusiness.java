package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.HistorialAccesoPublicacionDomain;

public interface HistorialAccesoPublicacionBusiness {
	
	void create(HistorialAccesoPublicacionDomain domain);

	List<HistorialAccesoPublicacionDomain> read(HistorialAccesoPublicacionDomain domain);

	void update(HistorialAccesoPublicacionDomain domain);

	void delete(HistorialAccesoPublicacionDomain domain);

}
