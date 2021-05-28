package HRMS.HRMS.business.abstracts;

import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.concretes.Employer;

public interface AuthService
{
	Result registerCandidate(Candidate candidate);
	Result registerEmployer(Employer employer);
} 
