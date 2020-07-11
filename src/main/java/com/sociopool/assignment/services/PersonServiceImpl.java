package com.sociopool.assignment.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sociopool.assignment.dto.DistanceTravelledDTO;
import com.sociopool.assignment.exceptions.CustomException;
import com.sociopool.assignment.models.Distance;
import com.sociopool.assignment.repositories.DistanceRepository;
import com.sociopool.assignment.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	PersonRepository personRepository;

	@Autowired
	DistanceRepository distanceRepository;

	@Override
	public Double getDistanceTravelled(DistanceTravelledDTO distanceTravelled) {
		logger.trace("Inside getDistanceTravelled method...");
		Double distance = 0d;
		try {
			List<Distance> distances = distanceRepository.findBetweenDates(distanceTravelled.person_id(),
					distanceTravelled.start().toString(), distanceTravelled.end().toString());
			distance = distances.stream().map(d -> d.getDistance()).reduce(0d, Double::sum);
		} catch (Exception e) {
			logger.error("Error occured while getting the distance travelled: " + e.getMessage());
			e.printStackTrace();
			throw new CustomException("Unable to retrieve distance.");
		}
		logger.debug("Distance Travelled: " + distance + " km between" + " " + distanceTravelled.start() + " and "
				+ distanceTravelled.end());
		return distance;
	}

}
