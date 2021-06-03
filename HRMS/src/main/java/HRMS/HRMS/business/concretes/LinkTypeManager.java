package HRMS.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.LinkTypeService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.LinkTypeDao;
import HRMS.HRMS.entities.concretes.LinkType;

@Service
public class LinkTypeManager implements LinkTypeService
{
	private LinkTypeDao linkTypeDao;

	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao)
	{
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public Result add(LinkType linkType)
	{
		this.linkTypeDao.save(linkType);
		return new SuccessResult("Link tipi eklendi");
	}

	@Override
	public DataResult<LinkType> getById(int linkTypeId)
	{
		return new SuccessDataResult<LinkType>(this.linkTypeDao.findById(linkTypeId));
	}
}
