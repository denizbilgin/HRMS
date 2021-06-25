package HRMS.HRMS.entities.concretes;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_links")
public class CandidateLink
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "user_id")
	//private int userId;
	
	//@Column(name = "link_type_id")
	//private int linkTypeId;
	
	@NotBlank
	@NotNull
	@Column(name = "link_path")
	private String linkPath;
	
	
	// JOINS
	
	//@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Candidate candidate;
	
	//@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="link_type_id")
	private LinkType linkType;
}
