package HRMS.HRMS.business.abstracts;

import java.util.List;



import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.School;

public interface SchoolService
{
	DataResult<List<School>> getByCandidateId(int candidateId);
	Result add(School school);
	DataResult<List<School>> getCandidateSchoolsDesc(int candidateId);
	Result update(School school);
}
