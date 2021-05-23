package com.pcalixto.displaydate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/date")
	public String date(Model viewmodel) {
		Date d = new java.util.Date();
		String dateAsStr = "";

		DateFormat dateFormat = new SimpleDateFormat("EEEE");
		dateAsStr += dateFormat.format(d);

		dateFormat = new SimpleDateFormat("d");
		dateAsStr += ", the " + dateFormat.format(d);

		dateFormat = new SimpleDateFormat("MMMM");
		dateAsStr += " of " + dateFormat.format(d);

		dateFormat = new SimpleDateFormat("y");
		dateAsStr += ", " + dateFormat.format(d);

		viewmodel.addAttribute("dateAsStr", dateAsStr);
		return "date.jsp";
	}

	@GetMapping("/time")
	public String time(Model viewmodel) {
		Date d = new java.util.Date();
		String timeAsStr = "";

		DateFormat dateFormat = new SimpleDateFormat("h");
		timeAsStr += dateFormat.format(d);

		dateFormat = new SimpleDateFormat("m");
		timeAsStr += ":" + dateFormat.format(d);

		dateFormat = new SimpleDateFormat("a");
		timeAsStr += " " + dateFormat.format(d);

		viewmodel.addAttribute("timeAsStr", timeAsStr);
		return "time.jsp";
	}
}
