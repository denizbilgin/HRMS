package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.entities.concretes.WorkingTime;

public interface WorkingTimeService
{
	DataResult<List<WorkingTime>> getAll();
}
