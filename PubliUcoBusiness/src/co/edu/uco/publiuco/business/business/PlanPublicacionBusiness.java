package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.PlanPublicacionDomain;

public interface PlanPublicacionBusiness {
	
	void create(PlanPublicacionDomain domain);

	List<PlanPublicacionDomain> read(PlanPublicacionDomain domain);

	void update(PlanPublicacionDomain domain);

	void delete(PlanPublicacionDomain domain);

}