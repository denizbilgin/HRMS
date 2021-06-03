package HRMS.HRMS.entities.dtos;


import java.util.List;

import HRMS.HRMS.entities.concretes.Candidate;
import HRMS.HRMS.entities.concretes.CandidateLink;
import HRMS.HRMS.entities.concretes.JobExperience;
import HRMS.HRMS.entities.concretes.Language;
import HRMS.HRMS.entities.concretes.School;
import HRMS.HRMS.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto
{
	private Candidate candidate;
	private List<CandidateLink> candidateLinks;
	private List<JobExperience> jobExperiences;
	private List<School> schools;
	private List<Skill> skills;
	private List<Language> languages;
	
	
}
