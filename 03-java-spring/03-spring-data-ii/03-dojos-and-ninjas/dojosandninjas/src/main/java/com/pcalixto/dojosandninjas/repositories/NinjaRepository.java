package com.pcalixto.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcalixto.dojosandninjas.models.Ninja;

@Repository()
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	public List<Ninja> findAll();
}
