package HRMS.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>
{
	List<JobExperience> findByCandidate_Id(int candidateId);
	JobExperience findById(int jobExperienceId);
	List<JobExperience> findByCandidate_IdOrderByFinishDateDesc(int candidateId);
}
