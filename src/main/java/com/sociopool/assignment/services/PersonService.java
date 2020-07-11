package com.sociopool.assignment.services;

import com.sociopool.assignment.dto.DistanceTravelledDTO;

public interface PersonService {

	/**
	 * Gets the distance traveled by the user in a specific duration
	 * 
	 * @param distanceTravelled
	 * @return {@link Double} distance
	 */
	Double getDistanceTravelled(DistanceTravelledDTO distanceTravelled);

}
