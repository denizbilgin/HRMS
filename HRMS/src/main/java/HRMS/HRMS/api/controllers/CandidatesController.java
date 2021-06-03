package HRMS.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.CandidateService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.dtos.CurriculumVitaeDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController
{
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService)
	{
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	public Result add(Candidate candidate)
	{
		return this.candidateService.add(candidate);
	}
	
	@PostMapping("/addDescription")
	public Result addDescription(@RequestParam int candidateId,@RequestParam String description)
	{
		return this.candidateService.addOrUpdateDescription(candidateId, description);
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll()
	{
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getCVByCandidateId")
	public DataResult<CurriculumVitaeDto> getCVByCandidateId(@RequestParam int candidateId)
	{
		return this.candidateService.getCVByCandidateId(candidateId);
	}

}
