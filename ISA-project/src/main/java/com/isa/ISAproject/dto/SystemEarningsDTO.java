package com.isa.ISAproject.dto;

public class SystemEarningsDTO {
	private Long id;

	private double percentage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public SystemEarningsDTO(Long id, double percentage) {
		super();
		this.id = id;
		this.percentage = percentage;
	}

	public SystemEarningsDTO() {
		super();
	}
	
	
	
	
	
	
}
