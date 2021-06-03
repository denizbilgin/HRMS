package HRMS.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>
{
	List<School> findByCandidate_Id(int candidateId);
	List<School> findByCandidate_IdOrderByGraduateDateDesc(int candidateId);
}
