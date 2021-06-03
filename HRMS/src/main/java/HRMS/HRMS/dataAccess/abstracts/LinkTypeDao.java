package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.entities.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer>
{
	LinkType findById(int id);
}
