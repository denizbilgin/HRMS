package HRMS.HRMS.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.SkillService;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Skill;

@CrossOrigin
@RestController
@RequestMapping("/api/skills")
public class SkillsController
{
	private SkillService skillService;

	public SkillsController(SkillService skillService)
	{
		this.skillService = skillService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Skill skill)
	{
		return this.skillService.add(skill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Skill skill)
	{
		return this.skillService.update(skill);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int skillId)
	{
		return this.skillService.delete(skillId);
	}
}
