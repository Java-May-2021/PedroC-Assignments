package com.pcalixto.driverslicense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcalixto.driverslicense.models.Person;

@Repository()
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();

	@Query(value=""
			+ "SELECT p.* "
			+ "FROM hmk_java030301_persons p "
			+ "LEFT OUTER JOIN hmk_java030301_licenses l ON p.id = l.person_id "
			+ "WHERE l.id IS NULL", nativeQuery=true)
	List<Person> findByNoLicense();
}
