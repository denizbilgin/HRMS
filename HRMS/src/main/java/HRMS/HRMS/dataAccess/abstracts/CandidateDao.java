package HRMS.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.dtos.CurriculumVitaeDto;

public interface CandidateDao extends JpaRepository<Candidate,Integer>
{
	Candidate findByNationalityId(String nationalityId);
	Candidate findById(int id);
}
