package HRMS.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.LinkTypeService;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.LinkType;

@CrossOrigin
@RestController
@RequestMapping("/api/linktypes")
public class LinkTypesController
{
	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypesController(LinkTypeService linkTypeService)
	{
		this.linkTypeService = linkTypeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody LinkType linkType)
	{
		return this.linkTypeService.add(linkType);
	}
}
