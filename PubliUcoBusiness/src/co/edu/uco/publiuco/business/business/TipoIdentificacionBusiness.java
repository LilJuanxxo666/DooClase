package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.TipoIdentificacionDomain;

public interface TipoIdentificacionBusiness {
	
	List<TipoIdentificacionDomain> read(TipoIdentificacionDomain domain);
	
	void update(TipoIdentificacionDomain domain);

}