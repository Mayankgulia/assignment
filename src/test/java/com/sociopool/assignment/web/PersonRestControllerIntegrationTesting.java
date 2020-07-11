package com.sociopool.assignment.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class PersonRestControllerIntegrationTesting {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getDistanceTravelled() throws JsonProcessingException {
		String url = "http://localhost:8080/person/distanceTravelled";
		String json = "{ \"person_id\": 1,\"start\": \"2020-07-08T13:30:00\", \"end\": \"2020-07-11T15:30:00\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());

		HttpEntity<String> request = new HttpEntity<>(json, headers);
		ResponseEntity<Double> response = restTemplate.postForEntity(url, request, Double.class);

		assertEquals(response.getBody(), 31.0d);
	}
}
