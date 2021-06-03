package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.SchoolService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.SchoolDao;
import HRMS.HRMS.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService
{
	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao)
	{
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getByCandidateId(int candidateId)
	{
		return new SuccessDataResult<List<School>>(this.schoolDao.findByCandidate_Id(candidateId));
	}

	@Override
	public Result add(School school)
	{
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}

	@Override
	public DataResult<List<School>> getCandidateSchoolsDesc(int candidateId)
	{
		return new SuccessDataResult<List<School>>(this.schoolDao.findByCandidate_IdOrderByGraduateDateDesc(candidateId));
	}
}
