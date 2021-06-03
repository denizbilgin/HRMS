package HRMS.HRMS.business.abstracts;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.LinkType;

public interface LinkTypeService
{
	Result add(LinkType linkType);
	DataResult<LinkType> getById(int linkTypeId);
}
