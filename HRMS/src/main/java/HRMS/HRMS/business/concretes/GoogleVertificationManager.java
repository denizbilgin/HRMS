package HRMS.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import HRMS.HRMS.business.abstracts.VertificationService;

@Service
public class GoogleVertificationManager implements VertificationService
{

	@Override
	public boolean emailVertification(String email)
	{
		System.out.println(email + " adresine kod gönderildi");
		System.out.println("Kod onaylandı!");
		return true;
	}

}
