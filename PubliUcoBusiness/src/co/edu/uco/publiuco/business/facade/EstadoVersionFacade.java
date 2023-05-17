package co.edu.uco.publiuco.business.facade;

import java.util.List;
import co.edu.uco.publiuco.dto.EstadoVersionDTO;

public interface EstadoVersionFacade {
	
	List<EstadoVersionDTO> list(EstadoVersionDTO dto);

}
