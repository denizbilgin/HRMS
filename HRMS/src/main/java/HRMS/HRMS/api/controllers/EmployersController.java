package HRMS.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.EmployerService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController
{
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService)
	{
		this.employerService = employerService;
	}

	@PostMapping("/add")
	public Result add(Employer employer)
	{
		return this.employerService.add(employer);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll()
	{
		return this.employerService.getAll();
	}
}
