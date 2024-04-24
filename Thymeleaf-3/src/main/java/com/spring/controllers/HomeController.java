package com.spring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.entities.LoginDto;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@GetMapping({ "/", "/home" })
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
		LoginDto dto = new LoginDto();
		model.addAttribute("loginDto", dto);
		return "login-form";
	}

	@PostMapping("/process-login")
	public String processLogin(@Valid @ModelAttribute("loginDto") LoginDto dto, BindingResult result,HttpSession session) {
		System.out.println("\nLogin-form Info:" + dto + "\n");
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.err.println(objectError);
			}
			return "login-form";
		} else {
			session.setAttribute("loginDto", dto);
			return "redirect:/success";
		}

	}

	@GetMapping("/success")
	public String success(HttpSession session,Model model) {
		Object dto = (LoginDto)session.getAttribute("loginDto");
		model.addAttribute("loginDto",dto);
		return "success";
	}

}
