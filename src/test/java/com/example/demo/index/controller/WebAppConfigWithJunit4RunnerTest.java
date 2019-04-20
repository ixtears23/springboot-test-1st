package com.example.demo.index.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class WebAppConfigWithJunit4RunnerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void homeTest() throws Exception {
		
		this.mockMvc.perform(post("/home")
				.accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andDo(print());
		
	}
	
}
