package com.pcalixto.routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping(value="/dojo/{location}", method=RequestMethod.GET)
	public String python(@PathVariable("location") String location) {
		if (location.equals("burbank")) {
			return "Burbank Dojo is located in Southern California";
		} else if (location.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		return "";
	}

}
