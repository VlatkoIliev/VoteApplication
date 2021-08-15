package com.VoteApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.VoteApplication.domain.User;
import com.VoteApplication.service.UserService;

@Controller
public class LogInController {
	
	@Autowired
	private UserService userService;

	// RequestMapping(value="/login", RequestMethod.GET)
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(User user) {
		User savedUser = userService.save(user);
		return "redirect:/login";
	}
}
