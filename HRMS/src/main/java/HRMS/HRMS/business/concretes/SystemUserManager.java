package HRMS.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.SystemUserService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.SystemUserDao;
import HRMS.HRMS.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService
{
	private SystemUserDao systemUserDao;

	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao)
	{
		this.systemUserDao = systemUserDao;
	}

	@Override
	public DataResult<List<SystemUser>> getAll()
	{
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll(),"Sistem kullanıcıları listelendi");
	}

	@Override
	public Result add(SystemUser systemUser)
	{
		this.systemUserDao.save(systemUser);
		return new SuccessResult("Sistem kullanıcısı eklendi");
	}

	@Override
	public Result update(SystemUser systemUser)
	{
		SystemUser systemUserToUpdate = this.systemUserDao.findById(systemUser.getId());
		systemUserToUpdate.setEmail(systemUser.getEmail());
		systemUserToUpdate.setFirstName(systemUser.getFirstName());
		systemUserToUpdate.setLastName(systemUser.getLastName());
		this.systemUserDao.save(systemUserToUpdate);
		return new SuccessResult("Sistem Kullanıcısı Bilgileriniz Güncellendi");
	}

	@Override
	public DataResult<SystemUser> getById(int systemUserId)
	{
		return new SuccessDataResult<SystemUser>(this.systemUserDao.findById(systemUserId),"Sistem Kullanıcısı Bilgileri Getirildi");
	}

}
