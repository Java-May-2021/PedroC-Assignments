package com.pcalixto.eventsbeltreviewer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pcalixto.eventsbeltreviewer.models.User;
import com.pcalixto.eventsbeltreviewer.services.UserService;

@Controller()
public class EventsController {
	UserService userService;

	public EventsController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/events")
	public String events(Model model, HttpSession session) {
		if (!authenticate(model, session)) {
			return "redirect:/";
		}
		return "events.jsp";
	}

	@GetMapping("/events/{id}")
	public String eventsShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (!authenticate(model, session)) {
			return "redirect:/";
		}
		return "show.jsp";
	}

	@GetMapping("/events/{id}/edit")
	public String eventsEdit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (!authenticate(model, session)) {
			return "redirect:/";
		}
		return "edit.jsp";
	}

	public boolean authenticate(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return false;
		}
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("loggedIn", true);
		return true;
	}

}
