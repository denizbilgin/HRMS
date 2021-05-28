package HRMS.HRMS.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForRegisterDto
{
	private String email;
	private String password;
	private String passwordRepeat;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private Date birthYear;
}
