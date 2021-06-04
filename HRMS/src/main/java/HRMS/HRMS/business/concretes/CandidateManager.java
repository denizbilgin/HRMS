package HRMS.HRMS.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import HRMS.HRMS.adapters.ImageService;
import HRMS.HRMS.business.abstracts.CandidateLinkService;
import HRMS.HRMS.business.abstracts.CandidateService;
import HRMS.HRMS.business.abstracts.JobExperienceService;
import HRMS.HRMS.business.abstracts.LanguageService;
import HRMS.HRMS.business.abstracts.SchoolService;
import HRMS.HRMS.business.abstracts.SkillService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.CandidateDao;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.dtos.CurriculumVitaeDto;

@Service
public class CandidateManager implements CandidateService
{
	private CandidateDao candidateDao;
	private CandidateLinkService candidateLinkService;
	private JobExperienceService jobExperienceService;
	private LanguageService languageService;
	private SchoolService schoolService;
	private SkillService skillService;
	private ImageService imageService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,CandidateLinkService candidateLinkService,
			JobExperienceService jobExperienceService,LanguageService languageService,
			SchoolService schoolService,SkillService skillService, ImageService imageService)
	{
		this.candidateDao = candidateDao;
		this.candidateLinkService = candidateLinkService;
		this.jobExperienceService = jobExperienceService;
		this.languageService = languageService;
		this.schoolService = schoolService;
		this.skillService = skillService;
		this.imageService = imageService;
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

	@Override
	public DataResult<CurriculumVitaeDto> getCVByCandidateId(int candidateId)
	{
		CurriculumVitaeDto dto = new CurriculumVitaeDto();
		dto.setCandidate(this.getById(candidateId).getData());
		dto.setCandidateLinks(this.candidateLinkService.getByCandidateId(candidateId).getData());
		dto.setJobExperiences(this.jobExperienceService.getByCandidateId(candidateId).getData());
		dto.setLanguages(this.languageService.getByCandidateId(candidateId).getData());
		dto.setSchools(this.schoolService.getByCandidateId(candidateId).getData());
		dto.setSkills(this.skillService.getByCandidateId(candidateId).getData());
		
		return new SuccessDataResult<CurriculumVitaeDto>(dto);
		
	}

	@Override
	public DataResult<Candidate> getById(int candidateId)
	{
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId));
	}

	@Override
	public Result addOrUpdateDescription(int candidateId, String description)
	{
		Candidate candidateToAddDescription = this.getById(candidateId).getData();
		candidateToAddDescription.setDescription(description);
		this.candidateDao.save(candidateToAddDescription);
		return new SuccessResult("Açıklama eklendi");
	}

	@Override
	public Result uploadImage(int candidateId, MultipartFile file)
	{
		Candidate candidateToAddPhoto = this.getById(candidateId).getData();
		
		Map<String, String> result = (Map<String, String>)this.imageService.savePhoto(file).getData();
		String url = result.get("url");
		candidateToAddPhoto.setImgUrl(url);
		this.candidateDao.save(candidateToAddPhoto);
		return new SuccessResult("Kullanıcının Resmi Eklendi");
	}

}
