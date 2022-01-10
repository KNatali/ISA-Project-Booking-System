package com.isa.ISAproject.controller;

import java.nio.charset.Charset;

import org.junit.Test;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static com.isa.ISAproject.constants.AdventureConstants.NEW_ADDRESS_STREET;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_ADDRESS_CITY;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_ADDRESS_STATE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_DESCRIPTION;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_PERCENTAGE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_PERSONS;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_PRICE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_GRADE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_ID;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_NAME;
import static com.isa.ISAproject.constants.AdventureConstants.DB_ADDRESS_STREET;
import static com.isa.ISAproject.constants.AdventureConstants.DB_ADDRESS_CITY;
import static com.isa.ISAproject.constants.AdventureConstants.DB_ADDRESS_STATE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_DESCRIPTION;
import static com.isa.ISAproject.constants.AdventureConstants.DB_PERCENTAGE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_PERSONS;
import static com.isa.ISAproject.constants.AdventureConstants.DB_PRICE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_GRADE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_NAME;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.isa.ISAproject.IsaProjectApplication;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.util.TestUtil;


import static com.isa.ISAproject.constants.InstructorConstants.NEW_FIRST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_LAST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_EMAIL;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_MOBILE;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_PASSWORD;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_USERNAME;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_ROLE;
import static com.isa.ISAproject.constants.InstructorConstants.DB_FIRST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.DB_LAST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.DB_EMAIL;
import static com.isa.ISAproject.constants.InstructorConstants.DB_MOBILE;
import static com.isa.ISAproject.constants.InstructorConstants.DB_PASSWORD;
import static com.isa.ISAproject.constants.InstructorConstants.DB_USERNAME;
import static com.isa.ISAproject.constants.InstructorConstants.DB_ROLE;
import static com.isa.ISAproject.constants.InstructorConstants.DB_ID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InstructorControllerTest {

	private static final String URL_PREFIX = "/api/instructors";

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());

	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	
	@Test
	@WithMockUser(username = "truman", authorities = { "ROLE_INSTRUCTOR" })
	public void testFindAll() throws Exception{
		mockMvc.perform(get(URL_PREFIX)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(5)))
		.andExpect(jsonPath("$.[*].firstName").value(hasItem(DB_FIRST_NAME)))
		.andExpect(jsonPath("$.[*].lastName").value(hasItem(DB_LAST_NAME)))
		.andExpect(jsonPath("$.[*].role").value(hasItem(DB_ROLE)))
		.andExpect(jsonPath("$.[*].username").value(hasItem(DB_USERNAME)))
		.andExpect(jsonPath("$.[*].email").value(hasItem(DB_EMAIL)));
		
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@WithMockUser(username = "truman", authorities = { "ROLE_INSTRUCTOR" })
	public void testChangePassword() throws Exception{
		PasswordChangeDTO passswordChange=new PasswordChangeDTO();
		passswordChange.setOldPassword(DB_PASSWORD);
		passswordChange.setNewPassword(NEW_PASSWORD);
		String json = TestUtil.json(passswordChange);
		mockMvc.perform(post(URL_PREFIX + "/changePassword/" + DB_ID).contentType(contentType).content(json)).andExpect(status().isOk());
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@WithMockUser(username = "truman", authorities = { "ROLE_INSTRUCTOR" })
	public void testGetInstructorAdventures() throws Exception{
		mockMvc.perform(get(URL_PREFIX + "/adventures/" +DB_ID )).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(4)))
		.andExpect(jsonPath("$.[*].name").value(hasItem(DB_NAME)))
		.andExpect(jsonPath("$.[*].price").value(hasItem(DB_PRICE)))
		.andExpect(jsonPath("$.[*].maxPersons").value(hasItem(DB_PERSONS)))
		.andExpect(jsonPath("$.[*].instructor.username").value(hasItem(DB_USERNAME)));
		
		
	}


}
