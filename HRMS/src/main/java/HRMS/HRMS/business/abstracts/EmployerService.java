package HRMS.HRMS.business.abstracts;

import java.util.List;


import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Employer;

public interface EmployerService
{
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
