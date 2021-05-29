package HRMS.HRMS.business.abstracts;

import java.util.List;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.entities.concretes.City;

public interface CityService
{
	DataResult<List<City>> getAll();
}
