package com.pcalixto.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pcalixto.driverslicense.models.License;

@Repository()
public interface LicenseRepository extends CrudRepository<License, Long> {
	public List<License> findAll();
}
