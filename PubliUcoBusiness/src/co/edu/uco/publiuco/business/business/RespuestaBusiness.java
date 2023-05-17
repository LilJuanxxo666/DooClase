package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.RespuestaDomain;

public interface RespuestaBusiness {
	
	List<RespuestaDomain> list(RespuestaDomain domain);

}