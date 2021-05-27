package HRMS.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.adapters.HumanCheckService;
import HRMS.HRMS.business.abstracts.AuthService;
import HRMS.HRMS.business.abstracts.CandidateService;
import HRMS.HRMS.business.abstracts.EmployerService;
import HRMS.HRMS.business.abstracts.UserService;
import HRMS.HRMS.business.abstracts.VertificationService;
import HRMS.HRMS.core.utilities.results.ErrorResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService
{
	private UserService userService;
	private HumanCheckService humanCheckService;
	private CandidateService candidateService;
	private EmployerService employerService;
	private VertificationService vertificationService;

	@Autowired
	public AuthManager(UserService userService, HumanCheckService humanCheckService, CandidateService candidateService,
			EmployerService employerService, VertificationService vertificationService)
	{
		this.userService = userService;
		this.humanCheckService = humanCheckService;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.vertificationService = vertificationService;
	}

	@Override
	public Result registerCandidate(Candidate candidate)
	{
		if (!this.checkIfEmailExists(candidate.getEmail()))
		{
			return new ErrorResult("Böyle bir email zaten var");
		}
		if (!this.checkIfValuesNullForCandidate(candidate))
		{
			return new ErrorResult("Bilgiler boş girilemez");
		}
		if (!this.checkIfRealPerson(candidate))
		{
			return new ErrorResult("Böyle bir kişi bulunamamaktadır");
		}
		if (!this.checkIfNationalityNumberExists(candidate.getNationalityId()))
		{
			return new ErrorResult("Bu kimlik numarasına sahip olan bir hesap zaten var");
		}

		this.vertificationService.emailVertification(candidate.getEmail());
		this.candidateService.add(candidate);
		return new SuccessResult("İş arayan kaydı başarılı");
	}

	@Override
	public Result registerEmployer(Employer employer)
	{
		if (!this.checkIfValuesNullForEmployer(employer))
		{
			return new ErrorResult("Bilgiler boş girilemez");
		}
		if (!this.checkIfEmailExists(employer.getEmail()))
		{
			return new ErrorResult("Böyle bir email zaten var");
		}
		if (!this.checkIfEqualEmailAndDomain(employer))
		{
			return new ErrorResult("Lütfen web sitenizle aynı domaine sahip bir email adresi yazınız");
		}
		
		this.vertificationService.emailVertification(employer.getEmail());
		this.employerService.add(employer);
		return new SuccessResult("İşveren kaydı başarılı");
	}

	// ABOUT CANDİDATE

	private boolean checkIfValuesNullForCandidate(Candidate candidate)
	{
		if (candidate.getFirstName() == null || candidate.getLastName() == null 
				|| candidate.getNationalityId() == null || candidate.getEmail() == null
				|| candidate.getPassword() == null)
		{
			return false;
		} else
		{
			return true;
		}
	}

	private boolean checkIfRealPerson(Candidate candidate)
	{
		if (this.humanCheckService.validateCandidate(candidate))
		{
			return true;
		} else
		{
			return false;
		}
	}

	private boolean checkIfNationalityNumberExists(String nationalityId)
	{
		if (this.candidateService.getByNationalityId(nationalityId).getData() == null)
		{
			return true;
		} else
		{
			return false;
		}
	}

	// ABOUT EMPLOYER

	private boolean checkIfValuesNullForEmployer(Employer employer)
	{
		if (employer.getCompanyName() == null || employer.getPhoneNumber() == null || employer.getWebAdress() == null
				|| employer.getEmail() == null || employer.getPassword() == null)
		{
			return false;
		} else
		{
			return true;
		}
	}

	private boolean checkIfEqualEmailAndDomain(Employer employer)
	{
		String[] emailArr = employer.getEmail().split("@",2);
		String domain = employer.getWebAdress().substring(4, employer.getWebAdress().length());
		
		if (emailArr[1].equals(domain)) {
			return true;
		}
		
		return false;
	}

	// ABOUT COMMON THİNGS

	private boolean checkIfEmailExists(String email)
	{
		if (this.userService.getUserByEmail(email).getData() == null)
		{
			return true;
		} else
		{
			return false;
		}
	}
}
