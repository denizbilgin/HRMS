package HRMS.HRMS.business.abstracts;
 
import java.util.List;

import HRMS.HRMS.entities.concretes.JobPosition;

public interface JobPositionService
{
	List<JobPosition> getAll();
}
