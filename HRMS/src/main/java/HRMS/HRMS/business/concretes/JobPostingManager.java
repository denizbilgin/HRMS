package HRMS.HRMS.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.JobPostingService;
import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.core.utilities.results.SuccessResult;
import HRMS.HRMS.dataAccess.abstracts.JobPostingDao;
import HRMS.HRMS.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService
{
	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao)
	{
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll()
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"İş ilanları listelendi");
	}

	@Override
	public Result add(JobPosting jobPosting)
	{
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		
		jobPosting.setListingDate(date);
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobPosting>> getActivePostings()
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrue(),"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getIsActiveTrueAndDeadlineDateEquals(Date deadlineDate)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndDeadlineDateEquals(deadlineDate),"Başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getIsActiveTrueAndEmployerId(int employerId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndEmployerId(employerId),"Başarılı");
	}

	@Override
	public DataResult<JobPosting> findById(int jobPostingId)
	{
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.findById(jobPostingId));
	}

	@Override
	public Result changeJobPostingIsActivity(int jobPostingId)
	{
		JobPosting jobPostingToUpdate = this.findById(jobPostingId).getData();
		if (jobPostingToUpdate.isActive() == true)
		{
			jobPostingToUpdate.setActive(false);
		}else {
			jobPostingToUpdate.setActive(true);
		}
		
		this.jobPostingDao.save(jobPostingToUpdate);
		return new SuccessResult("İlanın aktifliği değiştirildi");
	}

	@Override
	public DataResult<List<JobPosting>> getActiveByCityIdAndPositionId(int cityId, int positionId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndCity_IdAndJobPosition_PositionId(cityId, positionId));
	}

	@Override
	public DataResult<List<JobPosting>> getAll(int pageNo, int pageSize)
	{
		Pageable pageable = (Pageable)PageRequest.of(pageNo -1, pageSize);
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<JobPosting>> getByCityIdAndWorkingTimeId(int cityId, int workingTimeId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndCity_IdAndWorkingTime_Id(cityId, workingTimeId));
	}

	@Override
	public DataResult<List<JobPosting>> getByCityId(int cityId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndCity_Id(cityId));
	}

	@Override
	public DataResult<List<JobPosting>> getByWorkingTimeId(int workingTimeId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndWorkingTime_Id(workingTimeId));
	}
}
