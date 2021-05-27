package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.EmployerService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.EmployerDao;
import HRMS.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService
{
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao)
	{
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll()
	{
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler listelendi");
	}

	@Override
	public Result add(Employer employer)
	{
		this.employerDao.save(employer);
		return new SuccessResult("İşveren eklendi");
	}

}
