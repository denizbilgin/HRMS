package HRMS.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.AuthService;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController
{
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService)
	{
		this.authService = authService;
	}

	@PostMapping("/registercandidate")
	public Result registerCandidate(@RequestBody Candidate candidate)
	{
		return this.authService.registerCandidate(candidate);
	}
	
	@PostMapping("/registeremployer")
	public Result registerEmployer(@RequestBody Employer employer)
	{
		return this.authService.registerEmployer(employer);
	}

}
