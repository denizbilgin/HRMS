package HRMS.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.SystemUserService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUsersController
{
	private SystemUserService systemUserService;

	@Autowired
	public SystemUsersController(SystemUserService systemUserService)
	{
		this.systemUserService = systemUserService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemUser systemUser)
	{
		return this.systemUserService.add(systemUser);
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll()
	{
		return this.systemUserService.getAll();
	}
}
