package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.VersionDomain;

public interface VersionBusiness {

	void create(VersionDomain domain);

	List<VersionDomain> read(VersionDomain domain);

	void update(VersionDomain domain);

	void delete(VersionDomain domain);

}
