package com.example.demo.index.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.DemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = DemoApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = { "spring.mvc.view.prefix=/jsp/", "spring.mvc.view.suffix=.jsp", "spring.mvc.servlet.path=/" })
@AutoConfigureMockMvc
public class AutoConfigureMockMvcTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void indexTest() throws Exception {
		
		this.mockMvc.perform(post("/index")
				.accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andDo(print());
		
	}
	
}
