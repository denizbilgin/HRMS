package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Skill;

public interface SkillService
{
	DataResult<List<Skill>> getByCandidateId(int candidateId);
	Result add(Skill skill);
	Result update(Skill skill);
}
