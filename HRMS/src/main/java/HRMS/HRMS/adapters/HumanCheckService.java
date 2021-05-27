package HRMS.HRMS.adapters;

import HRMS.HRMS.entities.concretes.Candidate;

public interface HumanCheckService
{
	boolean validateCandidate(Candidate candidate);
}
