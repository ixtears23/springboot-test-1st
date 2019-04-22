package com.example.demo.index.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path = "/{id}/post/{name}/mean")
	public String getMapping(@PathVariable String id, @PathVariable String name) {
		String forwardUrl = id + "/" + "name";
		return forwardUrl;
	}
	
	@RequestMapping(path = "/getBody", headers = { "key=junseok", "Accept=application/json" }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public String getBody(@RequestBody String test) {
		return "home";
	}
}
