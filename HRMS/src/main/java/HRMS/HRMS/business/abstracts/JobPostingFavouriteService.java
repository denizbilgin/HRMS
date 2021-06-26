package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.JobPostingFavourite;

public interface JobPostingFavouriteService
{
	DataResult<List<JobPostingFavourite>> getFavouritesByCandidateId(int candidateId);
	Result changeJobPostingFavourite(int candidateId,int jobPostingId);
}
