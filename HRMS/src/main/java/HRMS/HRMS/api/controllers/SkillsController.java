package HRMS.HRMS.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.SkillService;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Skill;

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
}