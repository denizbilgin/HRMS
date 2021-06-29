package HRMS.HRMS.business.abstracts;

import java.util.List;


import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.SystemUser;

public interface SystemUserService
{
	DataResult<List<SystemUser>> getAll();
	Result add(SystemUser systemUser);
	Result update(SystemUser systemUser);
	DataResult<SystemUser> getById(int systemUserId);
}
