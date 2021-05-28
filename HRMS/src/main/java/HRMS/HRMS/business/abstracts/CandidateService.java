package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Candidate;

public interface CandidateService
{
	DataResult<Candidate> getByNationalityId(String nationalityId);
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate); 
}
