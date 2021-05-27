package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>
{
	User findUserByEmail(String email);
}
