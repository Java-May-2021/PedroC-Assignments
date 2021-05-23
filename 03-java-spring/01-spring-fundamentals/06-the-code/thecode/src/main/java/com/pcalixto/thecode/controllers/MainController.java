package com.pcalixto.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(@ModelAttribute("trainharder") String trainharder, 
						Model viewmodel) {
		viewmodel.addAttribute("trainharder", trainharder);
		return "index.jsp";
	}

	@PostMapping("/code")
	public String code(@RequestParam(value="thecode", required=false) String thecode,
					   RedirectAttributes redirectAttributes) {
		if (thecode == null) {
			return "redirect:/";
		} else if (thecode.equals("bushido")) {
			redirectAttributes.addFlashAttribute("trainharder", "You must train harder");
			return "code.jsp";
		}
		return "redirect:/";
	}
}
