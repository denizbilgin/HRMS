package HRMS.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.WorkingTimeService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.entities.concretes.WorkingTime;

@CrossOrigin
@RestController
@RequestMapping("/api/workingtimes")
public class WorkingTimesController
{
	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService)
	{
		this.workingTimeService = workingTimeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingTime>> getAll()
	{
		return this.workingTimeService.getAll();
	}
}
