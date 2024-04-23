package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entities.LoginDto;

import jakarta.validation.Valid;



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
	
	@GetMapping("/login-form")
	public String showLoginForm(Model model) {
		model.addAttribute("loginDto", new LoginDto());
		return "login-form";
	}
	
	@PostMapping("/process-login")
	public String processLogin(@Valid @ModelAttribute("loginDto") LoginDto loginDto,BindingResult result)  {
		if(result.hasErrors()) {
			return "login-form";
		}else {
			return "redirect:/success";
		}
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
}
