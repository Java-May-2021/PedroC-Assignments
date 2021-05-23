package com.pcalixto.hellohuman.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	@GetMapping("/")
	public String index(@RequestParam(value="name", required=false) String name,
						@RequestParam(value="last_name", required=false) String last_name,
						Model viewmodel) {
		String completename = "";
		if (name == null && last_name == null) {
			completename = "Human";
		} else {
			completename = "";
			if (name != null) {
				completename = name;
			}
			if (last_name != null) {
				completename += " " + last_name;
			}
		}

		viewmodel.addAttribute("completename", completename);
		return "index.jsp";
	}
}
