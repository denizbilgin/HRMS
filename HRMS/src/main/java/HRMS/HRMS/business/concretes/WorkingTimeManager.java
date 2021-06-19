package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.WorkingTimeService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.dataAccess.abstracts.WorkingTimeDao;
import HRMS.HRMS.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService
{
	private WorkingTimeDao workingTimeDao;

	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao)
	{
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public DataResult<List<WorkingTime>> getAll()
	{
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll(),"İş zamanları listelendi");
	}
}
