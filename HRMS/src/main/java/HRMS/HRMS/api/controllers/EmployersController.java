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
import org.springframework.web.multipart.MultipartFile;

import HRMS.HRMS.business.abstracts.EmployerService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Employer;

@CrossOrigin
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
	public Result add(@RequestBody Employer employer)
	{
		return this.employerService.add(employer);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll()
	{
		return this.employerService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(int employerId)
	{
		return this.employerService.getById(employerId);
	}
	
	@PostMapping("/uploadImage")
	public Result uploadImage(int employerId,MultipartFile file)
	{
		return this.employerService.uploadImage(employerId,file);
	}
	
	@PostMapping("/waitingUpdate")
	public Result waitingUpdate(@RequestBody Employer employer)
	{
		return this.employerService.waitingUpdate(employer);
	}
	
	@PostMapping("/confirmUpdate")
	public Result confirmUpdate(@RequestParam int employerId)
	{
		return this.employerService.confirmUpdate(employerId);
	}
}
