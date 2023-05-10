package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.RevisorDomain;

public interface RevisorBusiness {
	
	void create(RevisorDomain domain);

	List<RevisorDomain> read(RevisorDomain domain);

	void update(RevisorDomain domain);

	void delete(RevisorDomain domain);

}