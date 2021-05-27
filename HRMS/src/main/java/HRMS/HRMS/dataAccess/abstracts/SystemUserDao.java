package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.SystemUser;

public interface SystemUserDao extends JpaRepository<SystemUser,Integer>
{

}
