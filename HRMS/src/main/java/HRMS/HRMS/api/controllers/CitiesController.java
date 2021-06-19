package HRMS.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.CityService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.entities.concretes.City;

@CrossOrigin
@RestController
@RequestMapping("/api/cities")
public class CitiesController
{
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService)
	{
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll()
	{
		return this.cityService.getAll();
	}
}
