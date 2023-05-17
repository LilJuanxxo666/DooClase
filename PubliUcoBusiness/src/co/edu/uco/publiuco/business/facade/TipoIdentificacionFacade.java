package co.edu.uco.publiuco.business.facade;

import java.util.List;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;

public interface TipoIdentificacionFacade {
	
	List<TipoIdentificacionDTO> list(TipoIdentificacionDTO dto);
	
}