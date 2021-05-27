package HRMS.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "job_positions")
public class JobPosition
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "position_id")
	private int positionId;

	@Column(name = "position_name")
	private String positionName;

	public JobPosition()
	{

	}

	public JobPosition(int positionId, String positionName)
	{
		this.positionId = positionId;
		this.positionName = positionName;
	}
}
