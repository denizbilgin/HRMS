package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.CityService;
import HRMS.HRMS.business.constants.Messages;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.dataAccess.abstracts.CityDao;
import HRMS.HRMS.entities.concretes.City;

@Service
public class CityManager implements CityService
{
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao)
	{
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll()
	{
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),Messages.citiesListed);
	}
}
