package HRMS.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.JobExperienceService;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController
{
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService)
	{
		this.jobExperienceService = jobExperienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience)
	{
		return this.jobExperienceService.add(jobExperience);
	}
	
	@GetMapping("/getCandidateJobExperiencesDesc")
	public Result getCandidateJobExperiencesDesc(@RequestParam int candidateId)
	{
		return this.jobExperienceService.getCandidateJobExperiencesDesc(candidateId);
	}
}