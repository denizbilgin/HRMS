package HRMS.HRMS.business.abstracts;

import java.sql.Date;
import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.JobPosting;

public interface JobPostingService
{
	DataResult<List<JobPosting>> getAll();
	Result add(JobPosting jobPosting);
	DataResult<List<JobPosting>> getActivePostings();
	DataResult<List<JobPosting>> getIsActiveTrueAndDeadlineDateEquals(Date deadlineDate);
	DataResult<List<JobPosting>> getIsActiveTrueAndEmployerId(int employerId);
	DataResult<JobPosting> findById(int jobPostingId);
	Result changeJobPostingIsActivity(int jobPostingId);
	DataResult<List<JobPosting>> getActiveByCityIdAndPositionId(int cityId,int positionId);
}
