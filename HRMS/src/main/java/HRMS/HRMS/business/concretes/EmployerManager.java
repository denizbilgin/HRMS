package HRMS.HRMS.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import HRMS.HRMS.adapters.ImageService;
import HRMS.HRMS.business.abstracts.EmployerService;
import HRMS.HRMS.business.constants.Messages;
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
	private ImageService imageService;
	private ObjectMapper objectMapper;

	@Autowired
	public EmployerManager(EmployerDao employerDao,ImageService imageService,ObjectMapper objectMapper)
	{
		this.employerDao = employerDao;
		this.imageService = imageService;
		this.objectMapper = objectMapper;
	}

	@Override
	public DataResult<List<Employer>> getAll()
	{
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer)
	{
		this.employerDao.save(employer);
		return new SuccessResult(Messages.employerAdded);
	}

	@Override
	public Result uploadImage(int employerId, MultipartFile file)
	{
		Employer employerToUploadPhoto = this.getById(employerId).getData();
		
		Map<String, String> result = (Map<String, String>)this.imageService.savePhoto(file).getData();
		String url = result.get("url");
		employerToUploadPhoto.setImgUrl(url);
		this.employerDao.save(employerToUploadPhoto);
		return new SuccessResult(Messages.imageUploaded);
	}

	@Override
	public DataResult<Employer> getById(int employerId)
	{
		return new SuccessDataResult<Employer>(this.employerDao.findById(employerId));
	}

	@Override
	public Result waitingUpdate(Employer employer)
	{
		Employer employerToUpdate = this.getById(employer.getId()).getData();
		Map<String,Object> update = this.objectMapper.convertValue(employer,Map.class);
		employerToUpdate.setUpdateEmployer(update);
		this.employerDao.save(employerToUpdate);
		return new SuccessResult(Messages.employerUpdateIsWaiting);
	}

	@Override
	public Result confirmUpdate(int employerId)
	{
		Employer employerToConfirmUpdate = this.getById(employerId).getData();
		Employer tempEmployer = this.objectMapper.convertValue(employerToConfirmUpdate.getUpdateEmployer(), Employer.class);
		tempEmployer.setUpdateEmployer(null);
		this.employerDao.save(tempEmployer);
		return new SuccessResult(Messages.employerUpdateIsConfirmed);
	}

}
