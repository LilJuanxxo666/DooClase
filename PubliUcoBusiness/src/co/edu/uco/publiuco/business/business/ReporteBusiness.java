package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.ReporteDomain;

public interface ReporteBusiness {
	
	void create(ReporteDomain domain);

	List<ReporteDomain> read(ReporteDomain domain);

	void update(ReporteDomain domain);

	void delete(ReporteDomain domain);

}
