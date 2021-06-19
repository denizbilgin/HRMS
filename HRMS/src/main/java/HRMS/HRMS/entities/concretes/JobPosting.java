package HRMS.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_postings")
public class JobPosting
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	//@Column(name="job_position_id")
	//private int jobPositionId;
	
	//@Column(name="city_id")
	//private int cityId;
	
	@Min(value = 0)
	@Column(name="min_salary")
	private double minSalary;
	
	@Min(value = 0)
	@Column(name="max_salary")
	private double maxSalary;
	
	@NotBlank
	@NotNull
	@Min(value = 0)
	@Column(name="number_of_open_position")
	private int numberOfOpenPosition;
	
	@NotBlank
	@NotNull
	@Column(name="listing_date")
	private Date listingDate;
	
	@Column(name="deadline_date")
	private Date deadlineDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@NotBlank
	@NotNull
	@Column(name="job_description")
	private String jobDescription;
	
	
	// JOINS
	
	//name => kendi tablosundaki kolon adı
	@ManyToOne()
	@JoinColumn(name="employer_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Employer employer;
	
	@ManyToOne()
	//@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_type_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private JobType jobType;
	
	@ManyToOne()
	@JoinColumn(name = "working_time_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private WorkingTime workingTime;
} 
