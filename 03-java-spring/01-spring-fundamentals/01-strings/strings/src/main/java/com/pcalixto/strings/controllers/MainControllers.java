package com.pcalixto.strings.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainControllers {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Hello cient! How are you doing?";
	}

	@RequestMapping(value="/random", method=RequestMethod.GET)
	public String random() {
		return "Spring Boot is great! So easy to just respond with strings";
	}

}
