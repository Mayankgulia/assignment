package com.sociopool.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sociopool.assignment.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
