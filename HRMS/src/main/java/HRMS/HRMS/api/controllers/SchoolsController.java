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

import HRMS.HRMS.business.abstracts.SchoolService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.School;

@CrossOrigin
@RestController
@RequestMapping("/api/schools")
public class SchoolsController
{
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService)
	{
		this.schoolService = schoolService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody School school)
	{
		return this.schoolService.add(school);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody School school)
	{
		return this.schoolService.update(school);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int schoolId)
	{
		return this.schoolService.delete(schoolId);
	}

	@GetMapping("/getCandidateSchoolsDesc")
	public DataResult<List<School>> getCandidateSchoolsDesc(@RequestParam int candidateId)
	{
		return this.schoolService.getCandidateSchoolsDesc(candidateId);
	}
}
