package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.SkillService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.SkillDao;
import HRMS.HRMS.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService
{
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao)
	{
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getByCandidateId(int candidateId)
	{
		return new SuccessDataResult<List<Skill>>(this.skillDao.findByCandidate_Id(candidateId));
	}

	@Override
	public Result add(Skill skill)
	{
		this.skillDao.save(skill);
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public Result update(Skill skill)
	{
		Skill skillToUpdate = this.skillDao.findById(skill.getId());
		skillToUpdate.setSkillName(skill.getSkillName());
		this.skillDao.save(skillToUpdate);
		return new SuccessResult("Kullanıcı Bilgileri Güncellendi");
	}
}
