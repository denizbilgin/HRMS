package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.JobExperience;

public interface JobExperienceService
{
	DataResult<List<JobExperience>> getByCandidateId(int candidateId);
	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getCandidateJobExperiencesDesc(int candidateId);
	Result update(JobExperience jobExperience);
	Result delete(int candidateId);
}
