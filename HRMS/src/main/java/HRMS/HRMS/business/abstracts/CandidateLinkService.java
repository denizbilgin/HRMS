package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.CandidateLink;

public interface CandidateLinkService
{
	DataResult<List<CandidateLink>> getByCandidateId(int candidateId);
	Result add(CandidateLink candidateLink);
}
