package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.TipoRevisionDomain;

public interface TipoRevisionBusiness {
	
	List<TipoRevisionDomain> list(TipoRevisionDomain domain);

}