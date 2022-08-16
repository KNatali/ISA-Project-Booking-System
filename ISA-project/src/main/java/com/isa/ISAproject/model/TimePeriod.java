package com.isa.ISAproject.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TimePeriod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDateTime startTime;
	@Column
	private LocalDateTime endTime;
	
	@Column
    private UnavailabilityType timeType;
	
	
	@ManyToMany(mappedBy = "unavailability")
	private Set<Instructor> instructors=new HashSet<>();
	@ManyToMany(mappedBy = "unavailability")
	private Set<Cottage> cottages=new HashSet<>();
	@ManyToMany(mappedBy = "unavailability")
	private Set<Boat> boats=new HashSet<>();
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	
	
	public UnavailabilityType getTimeType() {
		return timeType;
	}

	public void setTimeType(UnavailabilityType type) {
		this.timeType = type;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}
	public Set<Boat> getBoats() {
		return boats;
	}

	public void setBoats(Set<Boat> boats) {
		this.boats = boats;
	}
	public Set<Cottage> getCottages() {
		return cottages;
	}

	public void setCottages(Set<Cottage> cottages) {
		this.cottages = cottages;
	}
	
	public TimePeriod(Long id, LocalDateTime start, LocalDateTime end, UnavailabilityType type) {
		super();
		this.id = id;
		this.startTime = start;
		this.endTime = end;
		this.timeType = type;
		
	}

	public TimePeriod() {
		super();
	}

	
}
