package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.RevisorRevisionDomain;

public interface RevisorRevisionBusiness {

	void create(RevisorRevisionDomain domain);

	List<RevisorRevisionDomain> read(RevisorRevisionDomain domain);

	void update(RevisorRevisionDomain domain);

	void delete(RevisorRevisionDomain domain);

}
