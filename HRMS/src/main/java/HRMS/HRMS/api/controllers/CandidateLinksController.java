package HRMS.HRMS.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.CandidateLinkService;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.CandidateLink;

@CrossOrigin
@RestController
@RequestMapping("/api/candidatelinks")
public class CandidateLinksController
{
	private CandidateLinkService candidateLinkService;

	public CandidateLinksController(CandidateLinkService candidateLinkService)
	{
		this.candidateLinkService = candidateLinkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateLink candidateLink)
	{
		return this.candidateLinkService.add(candidateLink);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CandidateLink candidateLink)
	{
		return this.candidateLinkService.update(candidateLink);
	}
	
	@PostMapping("/delete")
	public Result update(@RequestParam int linkId)
	{
		return this.candidateLinkService.delete(linkId);
	}
	
	@GetMapping("/getByCandidateId")
	public Result getByCandidateId(@RequestParam int candidateId)
	{
		return this.candidateLinkService.getByCandidateId(candidateId);
	}

}
