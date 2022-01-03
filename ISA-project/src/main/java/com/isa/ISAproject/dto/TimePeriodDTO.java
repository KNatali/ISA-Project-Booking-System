package com.isa.ISAproject.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

public class TimePeriodDTO {

	private Long id;

	private String start;
	
	private String end;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public TimePeriodDTO(Long id, String start, String end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}

	public TimePeriodDTO() {
		super();
	}
	
	
}
