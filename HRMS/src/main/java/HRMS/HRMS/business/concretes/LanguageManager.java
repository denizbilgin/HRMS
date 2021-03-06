package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.LanguageService;
import HRMS.HRMS.business.constants.Messages;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.LanguageDao;
import HRMS.HRMS.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService
{
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao)
	{
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getByCandidateId(int candidateId)
	{
		return new SuccessDataResult<List<Language>>(this.languageDao.findByCandidate_Id(candidateId));
	}

	@Override
	public Result add(Language language)
	{
		this.languageDao.save(language);
		return new SuccessResult(Messages.languageAdded);
	}

	@Override
	public Result update(Language language)
	{
		Language languageToUpdate = this.languageDao.findById(language.getId());
		languageToUpdate.setLanguageLevel(language.getLanguageLevel());
		languageToUpdate.setLanguageName(language.getLanguageName());
		this.languageDao.save(languageToUpdate);
		return new SuccessResult(Messages.candidatesLanguageUpdated);
	}

	@Override
	public Result delete(int languageId)
	{
		this.languageDao.deleteById(languageId);
		return new SuccessResult(Messages.languageDeleted);
	}
}
