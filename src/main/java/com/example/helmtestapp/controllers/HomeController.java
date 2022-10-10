package com.example.helmtestapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {	

	@GetMapping("hi")
	public String hi(Model model) {

		return "index";
	}

	@GetMapping("hello")
	@ResponseBody
	public String hello() {
		return "Hello, world";
	}
	
	private void addSystemPropertyToModel(String systemProperty, String modelAttribute, Model model) {
		String systemPropertyValue = System.getProperty(systemProperty);		
		model.addAttribute(modelAttribute, systemPropertyValue);		
	}
}
