package com.example.demo.index.controller;

import static org.mockito.Mockito.mock;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.DemoApplication;

/// TODO 오류 !!!
@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = DemoApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebMvcTestWithSpringRunnerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private IndexController indexController;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
	}
	
	@Test
	public void homeTest() throws Exception {
		
		indexController = mock(IndexController.class);
		
		this.mockMvc.perform(post("/home")
				.accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andDo(print());
		
	}
	
}
