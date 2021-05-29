package HRMS.HRMS.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.JobPostingService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobposting")
public class JobPostingsController
{
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService)
	{
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll()
	{
		return this.jobPostingService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting)
	{
		return this.jobPostingService.add(jobPosting);
	}

	@GetMapping("/getActivePostings")
	public DataResult<List<JobPosting>> getActivePostings()
	{
		return this.jobPostingService.getActivePostings();
	}

	@GetMapping("/getIsActiveTrueAndDeadlineDateEquals")
	public DataResult<List<JobPosting>> getIsActiveTrueAndDeadlineDateEquals(@RequestParam Date deadlineDate)
	{
		return this.jobPostingService.getIsActiveTrueAndDeadlineDateEquals(deadlineDate);
	}

	@GetMapping("/getIsActiveTrueAndEmployerId")
	public DataResult<List<JobPosting>> getIsActiveTrueAndEmployerId(@RequestParam int employerId)
	{
		return this.jobPostingService.getIsActiveTrueAndEmployerId(employerId);
	}

	@PostMapping("/changeJobPostingIsActivity")
	public Result changeJobPostingIsActivity(@RequestParam int jobPostingId)
	{
		return this.jobPostingService.changeJobPostingIsActivity(jobPostingId);
	}
}
