package HRMS.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto
{
	private String email;
	private String password;
	private String passwordRepeat;
	private String companyName;
	private String webAdress;
	private String phoneNumber;
}
