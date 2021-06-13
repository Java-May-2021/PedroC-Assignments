package com.pcalixto.driverslicense.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pcalixto.driverslicense.models.License;
import com.pcalixto.driverslicense.models.Person;
import com.pcalixto.driverslicense.services.LicenseService;
import com.pcalixto.driverslicense.services.PersonService;

@Controller
public class MainController {
    private final PersonService personService;
    private final LicenseService licenseService;
    
    public MainController(PersonService personService,
    					  LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/persons/new.jsp";
	}

	@PostMapping("/persons/new")
	public String newPerson(@Valid @ModelAttribute("person") Person person, 
 			  				BindingResult result) {
		if (result.hasErrors()) {
			return "/persons/new.jsp";
		} else {
			personService.createPerson(person); 
			return "redirect:/licenses/new";
		}		
	}

	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license,
							 Model viewmodel) {
		// List<Person> persons = getPersonsWithNoLicense();
		List<Person> persons = personService.listWithoutLicense();
		viewmodel.addAttribute("persons", persons);
		Map<String,String> states = getStateList();
		viewmodel.addAttribute("states", states);
		return "/licenses/new.jsp";
	}

	@PostMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("license") License license, 
							 BindingResult result,
							 Model viewmodel) {
		if (result.hasErrors()) {
			// List<Person> persons = getPersonsWithNoLicense();
			List<Person> persons = personService.listWithoutLicense();
			viewmodel.addAttribute("persons", persons);
			Map<String,String> states = getStateList();
			viewmodel.addAttribute("states", states);
			return "/licenses/new.jsp";
		} else {
			licenseService.createLicense(license); 
			return "redirect:/persons/" + license.getPerson().getId();
		}
	}

	@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model viewmodel) {
		Person person = this.personService.getPerson(id);
		viewmodel.addAttribute("person", person);
		if (person.getLicense() != null) {
			License license = person.getLicense();
			viewmodel.addAttribute("license", license);
		}
		return "/persons/show.jsp";
	}
	
	private List<Person> getPersonsWithNoLicense() {
		List<Person> eligiblePersons = new ArrayList<Person>();
		List<Person> persons = this.personService.listAll();
		List<License> licenses = this.licenseService.listAll();
		for (Person p : persons) {
        	boolean addPerson = true;
			for (License l : licenses) {
            	// System.out.println(l.getPerson().getId());
	            if (p.getId().equals(l.getPerson().getId())) {
	            	addPerson = false;
	            }
	        }
			if (addPerson) {
            	// System.out.println("Add:");
            	// System.out.println(p.getId());
	        	eligiblePersons.add(p);			
			}
        }
        return eligiblePersons;
	}

	private Map<String,String> getStateList() {
	    Map<String,String> states = new LinkedHashMap<String,String>();
	    states.put("CT", "CT");
	    states.put("NJ", "NJ");
	    states.put("NY", "NY");
	    states.put("PA", "PA");
	    return states;
	}

}
