package HRMS.HRMS.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@Table(name="candidates")
public class Candidate extends User
{
	@Size(min = 2,max = 25)
	@NotBlank
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Size(min = 2,max = 25)
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	@NotNull
	@Size(min = 11,max = 11)
	@Column(name="nationality_id")
	private String nationalityId;
	
	@NotBlank
	@NotNull
	@Column(name="birth_year")
	private Date birthYear;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
	@Column(name="img_url")
	private String imgUrl;

	@Size(min = 3,max = 300)
	@Column(name="description")
	private String description;
	
	
	// JOINS
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateLink> candidateLinks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Skill> skills;
}
