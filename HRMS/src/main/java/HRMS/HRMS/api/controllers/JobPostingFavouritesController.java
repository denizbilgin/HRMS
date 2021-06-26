package HRMS.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.JobPostingFavouriteService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.JobPostingFavourite;

@CrossOrigin
@RestController
@RequestMapping("/api/jobpostingfavourites")
public class JobPostingFavouritesController
{
	private JobPostingFavouriteService jobPostingFavouriteService;

	@Autowired
	public JobPostingFavouritesController(JobPostingFavouriteService jobPostingFavouriteService)
	{
		this.jobPostingFavouriteService = jobPostingFavouriteService;
	}

	@GetMapping("/getcandidatesfavourites")
	public DataResult<List<JobPostingFavourite>> getFavouritesByCandidateId(@RequestParam int candidateId)
	{
		return this.jobPostingFavouriteService.getFavouritesByCandidateId(candidateId);
	}
	
	@PostMapping("/changejobpostingfavourite")
	public Result changeJobPostingFavourite(@RequestParam int candidateId,@RequestParam int jobPostingId)
	{
		return this.jobPostingFavouriteService.changeJobPostingFavourite(candidateId, jobPostingId);
	}

}
