package com.sociopool.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sociopool.assignment.models.Distance;

public interface DistanceRepository extends JpaRepository<Distance, Long>, DistanceRepositoryCustom {

}
