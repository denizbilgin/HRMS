package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.CandidateService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.CandidateDao;
import HRMS.HRMS.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService
{
	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao)
	{
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<Candidate> getByNationalityId(String nationalityId)
	{
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalityId));
	}

	@Override
	public DataResult<List<Candidate>> getAll()
	{
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş Arayanlar Listelendi");
	}

	@Override
	public Result add(Candidate candidate)
	{
		this.candidateDao.save(candidate);
		return new SuccessResult("İş Arayan Eklendi");
	}

}
