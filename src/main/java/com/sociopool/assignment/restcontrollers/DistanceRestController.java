package com.sociopool.assignment.restcontrollers;

import java.util.Optional;

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

import com.sociopool.assignment.exceptions.CustomException;
import com.sociopool.assignment.models.Distance;
import com.sociopool.assignment.models.Person;
import com.sociopool.assignment.repositories.DistanceRepository;
import com.sociopool.assignment.repositories.PersonRepository;

@RestController
@RequestMapping("/distance")
public class DistanceRestController {

	Logger logger = LoggerFactory.getLogger(DistanceRestController.class);

	@Autowired
	private DistanceRepository distanceRepository;

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Creates a new Distance object
	 * 
	 * <p>
	 * {@link CustomException} is thrown if associated Person is not present.
	 * </p>
	 * 
	 * @param distance
	 * @return a newly create distance object
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Distance create(@Valid @RequestBody final Distance distance) {
		logger.trace("Request received for adding a new distance for person: " + distance.getPersonId());
		Optional<Person> person = personRepository.findById(distance.getPersonId());
		if (person.isPresent()) {
			logger.debug("Associated person found...");
			distance.setPerson(person.get());
		} else {
			logger.debug("Associated person found.Request will not be processed...");
			throw new CustomException("No Person found with this Id.");
		}
		logger.trace("Persisting distance...");
		return distanceRepository.save(distance);
	}
}
