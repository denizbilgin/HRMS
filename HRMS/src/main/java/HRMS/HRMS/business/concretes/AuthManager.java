package HRMS.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.adapters.HumanCheckService;
import HRMS.HRMS.business.abstracts.AuthService;
import HRMS.HRMS.business.abstracts.CandidateService;
import HRMS.HRMS.business.abstracts.EmployerService;
import HRMS.HRMS.business.abstracts.UserService;
import HRMS.HRMS.business.abstracts.VertificationService;
import HRMS.HRMS.business.constants.Messages;
import HRMS.HRMS.core.utilities.results.ErrorResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.concretes.Employer;
import HRMS.HRMS.entities.dtos.CandidateForRegisterDto;
import HRMS.HRMS.entities.dtos.EmployerForRegisterDto;

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
	public Result registerCandidate(CandidateForRegisterDto candidateForRegisterDto)
	{
		Candidate candidate = new Candidate();
		candidate.setEmail(candidateForRegisterDto.getEmail());
		candidate.setPassword(candidateForRegisterDto.getPassword());
		candidate.setFirstName(candidateForRegisterDto.getFirstName());
		candidate.setLastName(candidateForRegisterDto.getLastName());
		candidate.setBirthYear(candidateForRegisterDto.getBirthYear());
		candidate.setNationalityId(candidateForRegisterDto.getNationalityId());
		
		if (!this.checkIfValuesNullForCandidate(candidateForRegisterDto))
		{
			return new ErrorResult(Messages.informationsCannotBeBlank);
		}
		if (!this.checkIfRealPerson(candidate))
		{
			return new ErrorResult(Messages.noSuchPersonExists);
		}
		if (!this.checkIfEmailExists(candidateForRegisterDto.getEmail()))
		{
			return new ErrorResult(Messages.emailIsAlreadyExists);
		}
		if (!candidateForRegisterDto.getPassword().equals(candidateForRegisterDto.getPasswordRepeat()))
		{
			return new ErrorResult(Messages.enterPasswordsEqual);
		}
		if (!this.checkIfNationalityNumberExists(candidateForRegisterDto.getNationalityId()))
		{
			return new ErrorResult(Messages.nationalityIdIsAlreadyExists);
		}

		this.vertificationService.emailVertification(candidate.getEmail());
		this.candidateService.add(candidate);
		return new SuccessResult(Messages.candidatesRegistrySuccessful);
	}

	@Override
	public Result registerEmployer(EmployerForRegisterDto employerForRegisterDto)
	{
		Employer employer = new Employer();
		employer.setEmail(employerForRegisterDto.getEmail());
		employer.setPassword(employerForRegisterDto.getPassword());
		employer.setPhoneNumber(employerForRegisterDto.getPhoneNumber());
		employer.setCompanyName(employerForRegisterDto.getCompanyName());
		employer.setWebAdress(employerForRegisterDto.getWebAdress());
		
		
		if (!this.checkIfValuesNullForEmployer(employerForRegisterDto))
		{
			return new ErrorResult(Messages.informationsCannotBeBlank);
		}
		if (!this.checkIfEmailExists(employer.getEmail()))
		{
			return new ErrorResult(Messages.emailIsAlreadyExists);
		}
		if (!employerForRegisterDto.getPassword().equals(employerForRegisterDto.getPasswordRepeat()))
		{
			return new ErrorResult(Messages.enterPasswordsEqual);
		}
		if (!this.checkIfEqualEmailAndDomain(employerForRegisterDto))
		{
			return new ErrorResult(Messages.enterEmailAndDomainEqual);
		}
		
		this.vertificationService.emailVertification(employer.getEmail());
		this.employerService.add(employer);
		return new SuccessResult(Messages.employersRegistrySuccessful);
	}

	// ABOUT CAND??DATE

	private boolean checkIfValuesNullForCandidate(CandidateForRegisterDto candidateForRegisterDto)
	{
		if (candidateForRegisterDto.getFirstName() == null || candidateForRegisterDto.getLastName() == null 
				|| candidateForRegisterDto.getNationalityId() == null || candidateForRegisterDto.getEmail() == null
				|| candidateForRegisterDto.getPassword() == null)
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

	private boolean checkIfValuesNullForEmployer(EmployerForRegisterDto employerForRegisterDto)
	{
		if (employerForRegisterDto.getCompanyName() == null || employerForRegisterDto.getPhoneNumber() == null || employerForRegisterDto.getWebAdress() == null
				|| employerForRegisterDto.getEmail() == null || employerForRegisterDto.getPassword() == null)
		{
			return false;
		} else
		{
			return true;
		}
	}

	private boolean checkIfEqualEmailAndDomain(EmployerForRegisterDto employerForRegisterDto)
	{
		String[] emailArr = employerForRegisterDto.getEmail().split("@",2);
		String domain = employerForRegisterDto.getWebAdress().substring(4, employerForRegisterDto.getWebAdress().length());
		
		if (emailArr[1].equals(domain)) {
			return true;
		}
		
		return false;
	}

	// ABOUT COMMON TH??NGS

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
