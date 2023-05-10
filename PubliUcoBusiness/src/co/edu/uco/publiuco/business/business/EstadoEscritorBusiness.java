package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoTipoEscritorDomain;

public interface EstadoEscritorBusiness {

	List<EstadoTipoEscritorDomain> read(EstadoTipoEscritorDomain domain);

}
