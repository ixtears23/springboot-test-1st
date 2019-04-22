package com.example.demo.index.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AutowiredControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private IndexController indexController;
	
	@Before
	public void setup() {
		
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
		
		this.mockMvc = MockMvcBuilders
				.standaloneSetup(indexController)
				.setViewResolvers(viewResolver)
				.build();
	}
	
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
