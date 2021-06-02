package com.pcalixto.driverslicense.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcalixto.driverslicense.models.Person;

@Repository()
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
}
