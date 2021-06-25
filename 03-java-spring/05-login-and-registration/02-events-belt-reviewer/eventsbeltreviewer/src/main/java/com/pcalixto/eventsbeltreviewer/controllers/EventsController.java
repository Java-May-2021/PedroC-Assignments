package com.pcalixto.eventsbeltreviewer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller()
public class EventsController {

	@GetMapping("/events")
	public String events() {
		return "events.jsp";
	}

	@GetMapping("/events/{id}")
	public String eventsShow(@PathVariable("id") Long id) {
		return "show.jsp";
	}

	@GetMapping("/events/{id}/edit")
	public String eventsEdit(@PathVariable("id") Long id) {
		return "edit.jsp";
	}

}
