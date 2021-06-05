package com.pcalixto.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pcalixto.dojosandninjas.models.Dojo;
import com.pcalixto.dojosandninjas.models.Ninja;
import com.pcalixto.dojosandninjas.services.DojoService;
import com.pcalixto.dojosandninjas.services.NinjaService;

@Controller()
public class MainController {
	DojoService dojoService;
	NinjaService ninjaService;
	
	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}

	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, 
						  BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}		
	}

	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja,
						   Model viewmodel) {
		List<Dojo> dojos = this.dojoService.findAll();
		viewmodel.addAttribute("dojos", dojos);
		return "/ninjas/new.jsp";
	}

	@PostMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, 
						   BindingResult result,
						   Model viewmodel) {
		if (result.hasErrors()) {
			List<Dojo> dojos = this.dojoService.findAll();
			viewmodel.addAttribute("dojos", dojos);
			return "/ninjas/new.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}		
	}

	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id,
			   			   Model viewmodel) {
		Dojo dojo = this.dojoService.findById(id);
		viewmodel.addAttribute("dojo", dojo);

		List<Ninja> ninjas = this.ninjaService.getNinjas(id);
		viewmodel.addAttribute("ninjas", ninjas);

		return "/dojos/show.jsp";
	}
}
