package HRMS.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.JobTypeService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.entities.concretes.JobType;

@CrossOrigin
@RestController
@RequestMapping("/api/jobtypes")
public class JobTypesController
{
	private JobTypeService jobTypeService;

	@Autowired
	public JobTypesController(JobTypeService jobTypeService)
	{
		this.jobTypeService = jobTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobType>> getAll()
	{
		return this.jobTypeService.getAll();
	}
}
