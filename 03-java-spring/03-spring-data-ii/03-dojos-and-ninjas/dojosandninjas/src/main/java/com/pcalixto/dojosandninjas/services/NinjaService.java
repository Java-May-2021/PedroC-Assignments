package com.pcalixto.dojosandninjas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pcalixto.dojosandninjas.models.Ninja;
import com.pcalixto.dojosandninjas.repositories.NinjaRepository;

@Service()
public class NinjaService {
	private NinjaRepository repo;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.repo.save(ninja);
	}
	
	public List<Ninja> getNinjas(Long dojo_id) {
		List<Ninja> allNinjas = this.repo.findAll();
		List<Ninja> ninjas = new ArrayList<Ninja>();
		for(Ninja n: allNinjas) {
			if (n.getDojo().getId().equals(dojo_id)) {
				ninjas.add(n);
			}
		}
		
		return ninjas;
	}
}
