package com.sociopool.assignment.repositories;

import java.util.List;

import com.sociopool.assignment.models.Distance;

public interface DistanceRepositoryCustom {
	List<Distance> findBetweenDates(Long personId,String start, String end);
}
