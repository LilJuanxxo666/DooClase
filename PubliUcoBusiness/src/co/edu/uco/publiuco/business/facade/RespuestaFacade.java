package co.edu.uco.publiuco.business.facade;

import java.util.List;
import co.edu.uco.publiuco.dto.RespuestaDTO;

public interface RespuestaFacade {
	
	List<RespuestaDTO> list(RespuestaDTO dto);

}