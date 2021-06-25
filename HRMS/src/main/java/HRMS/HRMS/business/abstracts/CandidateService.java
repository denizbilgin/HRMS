package HRMS.HRMS.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.dtos.CurriculumVitaeDto;

public interface CandidateService
{
	DataResult<Candidate> getByNationalityId(String nationalityId);
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);  
	Result updateCv(Candidate candidate);  
	DataResult<CurriculumVitaeDto> getCVByCandidateId(int candidateId);
	DataResult<Candidate> getById(int candidateId);
	Result addOrUpdateDescription(int candidateId,String description);
	
	Result uploadImage(int candidateId, MultipartFile file);
}
