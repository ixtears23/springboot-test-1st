package com.example.demo.index.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping(
			value = "/home", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String home() {
		return "home";
	}
}
