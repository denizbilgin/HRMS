package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.JobPositionService;
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
	public List<JobPosition> getAll()
	{
		return this.jobPositionDao.findAll();
	}

}
