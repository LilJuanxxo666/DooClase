package co.edu.uco.publiuco.business.facade;

import java.util.List;
import co.edu.uco.publiuco.dto.TipoEscritorDTO;

public interface TipoEscritorFacade {
	
	List<TipoEscritorDTO> list(TipoEscritorDTO dto);
	
}
