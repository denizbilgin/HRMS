package HRMS.HRMS.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Employer;

public interface EmployerService
{
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	Result uploadImage(int employerId, MultipartFile file);
	DataResult<Employer> getById(int employerId);
	Result waitingUpdate(Employer employer);
	Result confirmUpdate(int employerId);
}
