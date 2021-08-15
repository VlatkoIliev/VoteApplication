package com.VoteApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.VoteApplication.domain.Product;
import com.VoteApplication.domain.User;
import com.VoteApplication.repository.ProductRepository;

@Controller
public class DashboardController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootView() {
		return "index";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(@AuthenticationPrincipal User user, ModelMap model) {
		
		  List<Product> products = productRepo.findByUser(user);
		  model.put("products", products);
	      return "dashboard";
	}

}
