package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.ComentarioRevisorDomain;

public interface ComentarioRevisorBusiness {
	
	void create(ComentarioRevisorDomain domain);

	List<ComentarioRevisorDomain> read(ComentarioRevisorDomain domain);

	void update(ComentarioRevisorDomain domain);

	void delete(ComentarioRevisorDomain domain);

}