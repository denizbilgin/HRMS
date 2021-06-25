package HRMS.HRMS.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/api/jobpostings")
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
	
	@GetMapping("/getallbypage")
	public DataResult<List<JobPosting>> getAll(int pageNo,int pageSize)
	{
		return this.jobPostingService.getAll(pageNo,pageSize);
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
	
	@GetMapping("/getActiveByCityIdAndPositionId")
	public DataResult<List<JobPosting>> getActiveByCityIdAndPositionId(@RequestParam int cityId,@RequestParam int positionId)
	{
		return this.jobPostingService.getActiveByCityIdAndPositionId(cityId, positionId);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobPosting> getById(@RequestParam int jobPostingId)
	{
		return this.jobPostingService.findById(jobPostingId);
	}

	@PostMapping("/changeJobPostingIsActivity")
	public Result changeJobPostingIsActivity(@RequestParam int jobPostingId)
	{
		return this.jobPostingService.changeJobPostingIsActivity(jobPostingId);
	}
	
	@GetMapping("/getbycityidandworkingtimeid")
	public DataResult<List<JobPosting>> getByCityAndWorkingTime(int cityId,int workingTimeId)
	{
		return this.jobPostingService.getByCityIdAndWorkingTimeId(cityId, workingTimeId);
	}
	
	@GetMapping("/getbycityid")
	public DataResult<List<JobPosting>> getByCityId(int cityId)
	{
		return this.jobPostingService.getByCityId(cityId);
	}
	
	@GetMapping("/getbyworkingtimeid")
	public DataResult<List<JobPosting>> getByWorkingTimeId(int workingTimeId)
	{
		return this.jobPostingService.getByWorkingTimeId(workingTimeId);
	}
	
	
}
