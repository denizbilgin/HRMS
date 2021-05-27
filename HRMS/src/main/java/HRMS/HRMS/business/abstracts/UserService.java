package HRMS.HRMS.business.abstracts;

import java.util.List;


import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.User;

public interface UserService
{
	Result add(User user);
	DataResult<User> getUserByEmail(String email);
	DataResult<List<User>> getAll();
}
