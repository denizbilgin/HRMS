package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.JobTypeService;
import HRMS.HRMS.business.constants.Messages;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.dataAccess.abstracts.JobTypeDao;
import HRMS.HRMS.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService
{
	private JobTypeDao jobTypeDao;

	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao)
	{
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public DataResult<List<JobType>> getAll()
	{
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(),Messages.jobTypesListed);
	}
}
