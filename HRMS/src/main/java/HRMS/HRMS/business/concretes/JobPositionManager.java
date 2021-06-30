package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.JobPositionService;
import HRMS.HRMS.business.constants.Messages;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.ErrorResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.JobPositionDao;
import HRMS.HRMS.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService
{
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao)
	{
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll()
	{
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public Result add(JobPosition jobPosition)
	{
		if (getByPositionName(jobPosition.getPositionName()).getData() != null)
		{
			return new ErrorResult(Messages.jobPositionIsAlreadyExists);
		} else
		{
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult(Messages.jobPositionAdded);
		}
	}
	
	@Override
	public DataResult<JobPosition> getByPositionName(String position)
	{
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPositionName(position));
	}

}
