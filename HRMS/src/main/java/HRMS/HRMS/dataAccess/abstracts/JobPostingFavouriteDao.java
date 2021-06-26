package HRMS.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.JobPostingFavourite;

public interface JobPostingFavouriteDao extends JpaRepository<JobPostingFavourite, Integer>
{
	List<JobPostingFavourite> findByCandidate_Id(int candidateId);
	JobPostingFavourite findByCandidate_IdAndJobPostingId(int candidateId,int jobPostingId);
}
