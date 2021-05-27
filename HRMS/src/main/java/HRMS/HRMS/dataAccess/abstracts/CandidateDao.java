package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer>
{
	Candidate findByNationalityId(String nationalityId);
}
