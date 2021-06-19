package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer>
{

}
