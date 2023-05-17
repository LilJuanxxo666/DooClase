package co.edu.uco.publiuco.business.facade;

import java.util.List;
import co.edu.uco.publiuco.dto.EstadoRevisionDTO;

public interface EstadoRevisionFacade {
	
	List<EstadoRevisionDTO> list(EstadoRevisionDTO dto);

}
