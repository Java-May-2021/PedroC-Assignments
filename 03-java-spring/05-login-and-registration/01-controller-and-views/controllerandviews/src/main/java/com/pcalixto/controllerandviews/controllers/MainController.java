package com.pcalixto.controllerandviews.controllers;

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

import com.pcalixto.controllerandviews.models.User;
import com.pcalixto.controllerandviews.services.UserService;
import com.pcalixto.controllerandviews.validators.UserValidator;

@Controller()
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
		 
	public MainController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@GetMapping("")
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("/registration")
	public String registration(@ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, 
							   BindingResult result, 
							   HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "registration.jsp";
		} else {
			User newUser = userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
	}	

	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, 
						@RequestParam("password") String password, 
						Model model, HttpSession session, 
						RedirectAttributes redirectAtts) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		}
		
		redirectAtts.addFlashAttribute("error", "Invalid Credentials");
		return "redirect:/login";
	}
		
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/login";
		}
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);

		return "home.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}


