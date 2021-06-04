package HRMS.HRMS.entities.concretes;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")
public class JobExperience
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "user_id")
	//private int userId;
	
	@NotBlank
	@NotNull
	@Size(min = 2)
	@Column(name = "workplace_name")
	private String workplaceName;
	
	@NotBlank
	@NotNull
	@Size(min = 2)
	@Column(name = "position")
	private String position;
	
	@NotBlank
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "finish_date")
	private Date finishDate;
	
	
	// Joins
	
	//@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Candidate candidate;
}
