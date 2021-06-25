package HRMS.HRMS.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import HRMS.HRMS.adapters.ImageService;
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
	private ImageService imageService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,ImageService imageService)
	{
		this.employerDao = employerDao;
		this.imageService = imageService;
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

	@Override
	public Result uploadImage(int employerId, MultipartFile file)
	{
		Employer employerToUploadPhoto = this.getById(employerId).getData();
		
		Map<String, String> result = (Map<String, String>)this.imageService.savePhoto(file).getData();
		String url = result.get("url");
		employerToUploadPhoto.setImgUrl(url);
		this.employerDao.save(employerToUploadPhoto);
		return new SuccessResult("İşveren resmi güncellendi.");
	}

	@Override
	public DataResult<Employer> getById(int employerId)
	{
		return new SuccessDataResult<Employer>(this.employerDao.findById(employerId));
	}

}
