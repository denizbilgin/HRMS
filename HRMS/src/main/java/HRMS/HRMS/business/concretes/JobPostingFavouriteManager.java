package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.CandidateService;
import HRMS.HRMS.business.abstracts.JobPostingFavouriteService;
import HRMS.HRMS.business.constants.Messages;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.JobPostingFavouriteDao;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.concretes.JobPostingFavourite;

@Service
public class JobPostingFavouriteManager implements JobPostingFavouriteService
{
	private JobPostingFavouriteDao jobPostingFavouriteDao;
	private CandidateService candidateService;

	@Autowired
	public JobPostingFavouriteManager(JobPostingFavouriteDao jobPostingFavouriteDao,CandidateService candidateService)
	{
		this.jobPostingFavouriteDao = jobPostingFavouriteDao;
		this.candidateService = candidateService;
	}

	@Override
	public DataResult<List<JobPostingFavourite>> getFavouritesByCandidateId(int candidateId)
	{
		return new SuccessDataResult<List<JobPostingFavourite>>(this.jobPostingFavouriteDao.findByCandidate_Id(candidateId));
	}

	@Override
	public Result changeJobPostingFavourite(int candidateId,int jobPostingId)
	{
		JobPostingFavourite result = this.jobPostingFavouriteDao.findByCandidate_IdAndJobPostingId(candidateId, jobPostingId);
		if (result != null)
		{
			this.jobPostingFavouriteDao.deleteById(result.getId());
		} else
		{
			JobPostingFavourite tempJobPostingFavourite = new JobPostingFavourite();
			Candidate tempCandidate = new Candidate();
			tempCandidate = this.candidateService.getById(candidateId).getData();
			tempJobPostingFavourite.setCandidate(tempCandidate);
			tempJobPostingFavourite.setJobPostingId(jobPostingId);
			this.jobPostingFavouriteDao.save(tempJobPostingFavourite);
		}
		return new SuccessResult(Messages.jobPostingAddedToFavourite);
	}
}
