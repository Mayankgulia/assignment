package com.sociopool.assignment.restcontrollers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sociopool.assignment.dto.DistanceTravelledDTO;
import com.sociopool.assignment.exceptions.CustomException;
import com.sociopool.assignment.models.Person;
import com.sociopool.assignment.repositories.PersonRepository;
import com.sociopool.assignment.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonRestController {

	Logger logger = LoggerFactory.getLogger(PersonRestController.class);

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Gets the distance traveled by the user in a specific duration
	 * 
	 * @param distanceTravelled
	 * @return {@link Double} distance
	 */
	@PostMapping
	@RequestMapping("/distanceTravelled")
	public Double getDistanceTravelled(@Valid @RequestBody final DistanceTravelledDTO distanceTravelled) {
		logger.trace("Request received for fetching distance travelled for a duration...");
		logger.trace("Calling getDistanceTravelled service method...");
		return personService.getDistanceTravelled(distanceTravelled);
	}

	/**
	 * Creates a new person
	 * 
	 * @param person
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person create(@Valid @RequestBody Person person) {
		logger.trace("Request received for adding a new person: " + person.getFirsName());
		try {
			logger.trace("Adding person in the database...");
			person = personRepository.save(person);
			logger.trace("Person added in the database...");
		} catch (Exception e) {
			logger.error("Error occurred while adding Person: " + e.getMessage());
			e.printStackTrace();
			throw new CustomException("Unable to add Person.");
		}
		return person;
	}

}
