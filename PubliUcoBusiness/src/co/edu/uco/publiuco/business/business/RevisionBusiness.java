package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.RevisionDomain;

public interface RevisionBusiness {
	
	void create(RevisionDomain domain);

	List<RevisionDomain> read(RevisionDomain domain);

	void update(RevisionDomain domain);

	void delete(RevisionDomain domain);

}