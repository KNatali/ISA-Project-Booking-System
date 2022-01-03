package com.isa.ISAproject.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@ManyToMany(mappedBy = "unavailability")
	private Set<Instructor> instructors=new HashSet<>();
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
	
	
	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	public TimePeriod(Long id,LocalDateTime start, LocalDateTime end) {
		super();
		this.id=id;
		this.start = start;
		this.end = end;
	}
	public TimePeriod() {
		super();
	}

	
}
