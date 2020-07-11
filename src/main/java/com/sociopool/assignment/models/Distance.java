package com.sociopool.assignment.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Distance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distance_id")
	private Long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "person_id", nullable = false)
	@JsonIgnore
	private Person person;
	@Transient
	@NotNull(message="Person Id cannot be null")
	private Long personId;
	@Column
	@Min(value = 0, message = "Distance cannot be less than zero")
	private Double distance;
	@Column(name = "start_time", nullable = false)
	@Past(message = "Start time cannot be in future")
	private LocalDateTime startTime;
	@Column(name = "end_time", nullable = false)
	@Past(message = "End time cannot be in future")
	private LocalDateTime endTime;

}
