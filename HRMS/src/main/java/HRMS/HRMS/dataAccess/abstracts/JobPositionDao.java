package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>
{

}
