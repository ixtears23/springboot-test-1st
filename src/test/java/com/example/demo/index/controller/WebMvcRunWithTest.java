package com.example.demo.index.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class WebMvcRunWithTest {

	@Autowired
	private MockMvc mockMvc;
	
	private String id;
	private String name;
	
	@Before
	public void setup() {
		id = "ojs";
		name = "junseok";
	}
	
	@Test
	public void homeTest() throws Exception {
		
		this.mockMvc.perform(post("/home")
				.accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andDo(print());
		
	}
	
	@Test
	public void getMappingTest() throws Exception {
		String viewName = id + "/" + "name";
		MvcResult mvcResult = this.mockMvc.perform(get("/{id}/post/{name}/mean", id, name))
				.andExpect(view().name(viewName))
				.andReturn();
		
		Assert.assertThat(HttpServletResponse.SC_OK, is(mvcResult.getResponse().getStatus()) );
	}
	
	@Test
	public void getBodyTest() throws Exception {
		
		ResultActions resultAction = this.mockMvc.perform(get("/getBody")
				.content("234=234")
				.header("key", "junseok")
				.header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.header("Accept", "application/json"));
		
		resultAction.andDo(print());
		MvcResult mvcResult = resultAction.andReturn();
		
		Assert.assertThat(200, is(mvcResult.getResponse().getStatus()) );
	}
	
	//TODO JSON TEST
	@Test
	public void jsonBodyTest() throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String reqJson = objectMapper.writeValueAsString(new String[] {"1"});
	}
	
	
}
