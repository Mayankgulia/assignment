package com.sociopool.assignment.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long id;
	@Column(name = "first_name", nullable = false)
	@NotNull(message = "First Name cannot be null")
	@NotBlank(message = "First Name cannot be empty")
	private String firsName;
	@Column(name = "last_name")
	@NotNull
	private String lastName;
	@Column(name = "age", nullable = false)
	@Min(value = 16, message = "Age should not be less than 16")
	private int age;
	@Column(name = "email", nullable = false)
	@Email(message = "Invalid E-mail")
	private String email;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<Distance> distances;
}
