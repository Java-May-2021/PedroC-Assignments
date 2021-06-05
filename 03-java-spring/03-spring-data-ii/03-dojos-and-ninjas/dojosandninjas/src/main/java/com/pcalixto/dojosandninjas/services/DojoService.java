package com.pcalixto.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcalixto.dojosandninjas.models.Dojo;
import com.pcalixto.dojosandninjas.repositories.DojoRepository;

@Service()
public class DojoService {
	private DojoRepository repo;
	
	public DojoService(DojoRepository repo) {
		this.repo = repo;
	}

	public Dojo createDojo(Dojo dojo) {
		return this.repo.save(dojo);
	}
	
	public List<Dojo> findAll() {
		return this.repo.findAll();
	}

	public Dojo findById(Long id) {
		return this.repo.findById(id).orElse(null);
	}
}
