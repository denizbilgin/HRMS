package HRMS.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer extends User
{
	@NotBlank
	@NotNull
	@Size(min = 2)
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name="web_adress")
	private String webAdress;
	
	@NotBlank
	@NotNull
	@Size(min = 10,max = 11)
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_activated", columnDefinition="boolean default false")
	private boolean isActivated;
	

	// JOINS
	
	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;
}
