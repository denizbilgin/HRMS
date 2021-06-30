package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.JobExperienceService;
import HRMS.HRMS.business.constants.Messages;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.JobExperienceDao;
import HRMS.HRMS.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService
{
	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao)
	{
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getByCandidateId(int candidateId)
	{
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findByCandidate_Id(candidateId));
	}

	@Override
	public Result add(JobExperience jobExperience)
	{
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult(Messages.jobExperienceAdded);
	}

	@Override
	public DataResult<List<JobExperience>> getCandidateJobExperiencesDesc(int candidateId)
	{
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findByCandidate_IdOrderByFinishDateDesc(candidateId));
	}

	@Override
	public Result update(JobExperience jobExperience)
	{
		JobExperience jobExperienceToUpdate = this.jobExperienceDao.findById(jobExperience.getId());
		jobExperienceToUpdate.setFinishDate(jobExperience.getFinishDate());
		jobExperienceToUpdate.setPosition(jobExperience.getPosition());
		jobExperienceToUpdate.setStartDate(jobExperience.getStartDate());
		jobExperienceToUpdate.setWorkplaceName(jobExperience.getWorkplaceName());
		this.jobExperienceDao.save(jobExperienceToUpdate);
		return new SuccessResult(Messages.candidatesJobExperienceUpdated);
	}

	@Override
	public Result delete(int candidateId)
	{
		this.jobExperienceDao.deleteById(candidateId);
		return new SuccessResult(Messages.jobExperienceDeleted);
	}
}
