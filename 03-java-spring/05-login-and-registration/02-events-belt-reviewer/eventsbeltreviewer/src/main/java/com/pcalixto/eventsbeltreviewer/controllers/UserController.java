package com.pcalixto.eventsbeltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pcalixto.eventsbeltreviewer.models.User;
import com.pcalixto.eventsbeltreviewer.services.UserService;
import com.pcalixto.eventsbeltreviewer.validators.UserValidator;

@Controller()
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
		 
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}

	@PostMapping("/registration")
	public String index(@Valid @ModelAttribute("user") User user, 
						BindingResult result, 
						HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			User newUser = userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/events";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, 
						@RequestParam("password") String password, 
						Model model, HttpSession session, 
						RedirectAttributes redirectAtts) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/events";
		}
		
		redirectAtts.addFlashAttribute("loginErrors", "Invalid Credentials");
		return "redirect:/";
	}
	

}
