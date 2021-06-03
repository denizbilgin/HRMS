package HRMS.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>
{
	List<Skill> findByCandidate_Id(int candidateId);
}
