package HRMS.HRMS.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto
{
	private String companyName;
	private String jobDescription;
	private int numberOfOpenPosition;
	private Date listingDate;
	private Date deadlineDate;
}
