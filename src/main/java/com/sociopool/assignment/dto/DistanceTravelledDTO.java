package com.sociopool.assignment.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
public class DistanceTravelledDTO {
	private final @NonNull Long person_id;
	private final @NonNull LocalDateTime start;
	private final @NonNull LocalDateTime end;
}
