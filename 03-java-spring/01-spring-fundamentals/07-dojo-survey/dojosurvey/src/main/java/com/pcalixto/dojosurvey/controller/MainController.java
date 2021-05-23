package com.pcalixto.dojosurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@PostMapping("/result")
	public String result(@RequestParam(value="name") String name,
						 @RequestParam(value="location") String location,
						 @RequestParam(value="favlanguage") String favlanguage,
						 @RequestParam(value="comment", required=false) String comment,
						 Model viewmodel) {
		viewmodel.addAttribute("name", name);
		viewmodel.addAttribute("location", location);
		viewmodel.addAttribute("favlanguage", favlanguage);
		viewmodel.addAttribute("comment", comment);
		return "result.jsp";
	}
}
