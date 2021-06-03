package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Language;

public interface LanguageService
{
	DataResult<List<Language>> getByCandidateId(int candidateId);
	Result add(Language language);
}
