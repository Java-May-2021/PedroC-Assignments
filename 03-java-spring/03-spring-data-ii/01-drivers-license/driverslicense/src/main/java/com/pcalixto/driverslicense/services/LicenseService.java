package com.pcalixto.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcalixto.driverslicense.models.License;
import com.pcalixto.driverslicense.models.Person;
import com.pcalixto.driverslicense.repositories.LicenseRepository;

@Service()
public class LicenseService {
	private LicenseRepository repo;
	
	public LicenseService(LicenseRepository repo) {
		this.repo = repo;
	}
	
	public List<License> listAll() {
		return repo.findAll();
	}

	public License createLicense(License license) {
		return this.repo.save(license);
	}
	
	public License getLicense(Long id) {
		return this.repo.findById(id).orElse(null);
	}
}
