package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.PlanCategoriaDomain;

public interface PlanCategoriaBusiness {
	
	void create(PlanCategoriaDomain domain);

	List<PlanCategoriaDomain> read(PlanCategoriaDomain domain);

	void update(PlanCategoriaDomain domain);

	void delete(PlanCategoriaDomain domain);

}