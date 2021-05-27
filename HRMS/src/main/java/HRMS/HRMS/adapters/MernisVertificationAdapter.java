package HRMS.HRMS.adapters;

import org.springframework.stereotype.Service;

import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.microservices.Mernis.MernisVertification;

@Service
public class MernisVertificationAdapter implements HumanCheckService
{

	@Override
	public boolean validateCandidate(Candidate candidate)
	{
		MernisVertification client =new MernisVertification();
		
		boolean result = true;
		result = client.validatePerson(candidate.getFirstName(), candidate.getLastName(), candidate.getNationalityId());
		return result;
	}

}
