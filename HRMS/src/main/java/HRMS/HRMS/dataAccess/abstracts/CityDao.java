package HRMS.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.HRMS.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>
{

}
