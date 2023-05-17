package co.edu.uco.publiuco.business.facade;

import java.util.List;
import co.edu.uco.publiuco.dto.EstadoLectorDTO;

public interface EstadoLectorFacade {

	List<EstadoLectorDTO> list(EstadoLectorDTO dto);

}
