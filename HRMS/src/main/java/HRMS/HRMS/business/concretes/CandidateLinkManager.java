package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.CandidateLinkService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.CandidateLinkDao;
import HRMS.HRMS.entities.concretes.CandidateLink;

@Service
public class CandidateLinkManager implements CandidateLinkService
{
	private CandidateLinkDao candidateLinkDao;

	@Autowired
	public CandidateLinkManager(CandidateLinkDao candidateLinkDao)
	{
		this.candidateLinkDao = candidateLinkDao;
	}

	@Override
	public DataResult<List<CandidateLink>> getByCandidateId(int candidateId)
	{
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.findByCandidate_Id(candidateId),"Kişinin CV'si getirildi");
	}

	@Override
	public Result add(CandidateLink candidateLink)
	{
		this.candidateLinkDao.save(candidateLink);
		return new SuccessResult("Link başarıyla eklendi");
	}
}
