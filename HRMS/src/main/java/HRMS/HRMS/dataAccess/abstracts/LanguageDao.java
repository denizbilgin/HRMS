package HRMS.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>
{
	List<Language> findByCandidate_Id(int candidateId);
	Language findById(int languageId);
}
