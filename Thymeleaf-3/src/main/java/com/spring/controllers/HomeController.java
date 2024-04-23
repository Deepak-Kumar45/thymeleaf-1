package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("title", "MySunShine");
		model.addAttribute("services", "Our Services");
		return "home";
	}
	
	@GetMapping("/aboutus")
	public String about() {
		return "about";
	}
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
	
}
