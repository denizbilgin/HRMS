package HRMS.HRMS.business.abstracts;

import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.concretes.Employer;
import HRMS.HRMS.entities.dtos.CandidateForRegisterDto;
import HRMS.HRMS.entities.dtos.EmployerForRegisterDto;

public interface AuthService
{
	Result registerCandidate(CandidateForRegisterDto candidateForRegisterDto);
	Result registerEmployer(EmployerForRegisterDto employerForRegisterDto);
} 
