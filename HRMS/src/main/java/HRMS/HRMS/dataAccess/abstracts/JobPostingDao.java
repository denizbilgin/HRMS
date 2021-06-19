package HRMS.HRMS.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>
{
	List<JobPosting> findByIsActiveTrue();
	List<JobPosting> findByIsActiveTrueAndDeadlineDateEquals(Date deadlineDate);
	List<JobPosting> findByIsActiveTrueAndEmployerId(int employerId);
	JobPosting findById(int jobPostingId);
	List<JobPosting> findByIsActiveTrueAndCity_IdAndJobPosition_PositionId(int cityId,int positionId);
}
