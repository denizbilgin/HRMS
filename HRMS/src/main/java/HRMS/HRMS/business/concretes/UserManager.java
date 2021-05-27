package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.UserService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.UserDao;
import HRMS.HRMS.entities.concretes.User;

@Service
public class UserManager implements UserService
{
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public Result add(User user)
	{
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> getUserByEmail(String email)
	{
		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email),email + " emailine sahip olan kullanıcı listelendi");
	}

	@Override
	public DataResult<List<User>> getAll()
	{
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar listelendi");
	}

}
