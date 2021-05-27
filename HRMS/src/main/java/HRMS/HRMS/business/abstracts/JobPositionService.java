package HRMS.HRMS.business.abstracts;
 
import java.util.List;


import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.JobPosition;

public interface JobPositionService
{
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	DataResult<JobPosition> getByPositionName(String position);
}
