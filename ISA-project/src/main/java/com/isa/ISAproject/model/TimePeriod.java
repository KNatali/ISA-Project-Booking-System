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
	private LocalDateTime start;
	@Column
	private LocalDateTime end;
	
	@Enumerated(EnumType.STRING)
    private UnavailabilityType type;
	
	
	@ManyToMany(mappedBy = "unavailability")
	private Set<Instructor> instructors=new HashSet<>();
	@ManyToMany(mappedBy = "unavailability")
	private Set<Cottage> cottages=new HashSet<>();
	public LocalDateTime getStart() {
		return start;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
	
	
	public UnavailabilityType getType() {
		return type;
	}

	public void setType(UnavailabilityType type) {
		this.type = type;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
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
		this.start = start;
		this.end = end;
		this.type = type;
		
	}

	public TimePeriod() {
		super();
	}

	
}
