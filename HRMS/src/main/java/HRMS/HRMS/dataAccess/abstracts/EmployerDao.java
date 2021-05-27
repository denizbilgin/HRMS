package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>
{
	
}
