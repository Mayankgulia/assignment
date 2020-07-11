package com.sociopool.assignment.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sociopool.assignment.models.Distance;

@Repository
public class DistanceRepositoryCustomImpl implements DistanceRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Distance> findBetweenDates(Long personId, String start, String end) {
		Query query = entityManager.createNativeQuery(
				"select * from distance where ? <=START_TIME and ? >=END_TIME and PERSON_ID=?", Distance.class);
		query.setParameter(1, start);
		query.setParameter(2, end);
		query.setParameter(3, personId);

		return query.getResultList();
	}

}
