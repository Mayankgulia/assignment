package com.sociopool.assignment.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sociopool.assignment.repositories.PersonRepository;
import com.sociopool.assignment.restcontrollers.PersonRestController;
import com.sociopool.assignment.services.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class PersonRestControllerUnitTesting {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	@Test
	public void getDistanceTravelled() throws Exception {
		String uri = "/person/distanceTravelled";
		String json = "{ \"person_id\": 1,\"start\": \"2020-07-08T13:30:00\", \"end\": \"2020-07-11T15:30:00\"}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("0.0"));
	}
}
