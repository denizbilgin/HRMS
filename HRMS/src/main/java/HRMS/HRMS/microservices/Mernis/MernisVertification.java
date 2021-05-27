package HRMS.HRMS.microservices.Mernis;

public class MernisVertification
{
	public boolean validatePerson(String firstName, String lastName, String nationalityId)
	{
		System.out.println(firstName + " " + lastName + " is real person!");
		return true;
	}
}
