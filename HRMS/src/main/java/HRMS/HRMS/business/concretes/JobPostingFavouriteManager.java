package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.JobPostingFavouriteService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.JobPostingFavouriteDao;
import HRMS.HRMS.entities.concretes.JobPostingFavourite;

@Service
public class JobPostingFavouriteManager implements JobPostingFavouriteService
{
	private JobPostingFavouriteDao jobPostingFavouriteDao;

	@Autowired
	public JobPostingFavouriteManager(JobPostingFavouriteDao jobPostingFavouriteDao)
	{
		this.jobPostingFavouriteDao = jobPostingFavouriteDao;
	}

	@Override
	public DataResult<List<JobPostingFavourite>> getFavouritesByCandidateId(int candidateId)
	{
		return new SuccessDataResult<List<JobPostingFavourite>>(this.jobPostingFavouriteDao.findByCandidate_Id(candidateId));
	}

	@Override
	public Result addFavourite(JobPostingFavourite jobPostingFavourite)
	{
		this.jobPostingFavouriteDao.save(jobPostingFavourite);
		return new SuccessResult("İlan Favoriye Eklendi");
	}

	@Override
	public Result removeFavourite(int favouriteId)
	{
		this.jobPostingFavouriteDao.deleteById(favouriteId);
		return new SuccessResult("İlan Favorilerden Çıkarıldı");
	}
}
