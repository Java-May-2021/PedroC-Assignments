package com.pcalixto.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcalixto.driverslicense.models.License;
import com.pcalixto.driverslicense.models.Person;
import com.pcalixto.driverslicense.repositories.PersonRepository;

@Service()
public class PersonService {
	private PersonRepository repo;
	
	public PersonService(PersonRepository repo) {
		this.repo = repo;
	}
	
	public List<Person> listAll() {
		return repo.findAll();
	}

	public Person createPerson(Person person) {
		return repo.save(person);
	}
	
	public Person getPerson(Long id) {
		return this.repo.findById(id).orElse(null);
	}

}
