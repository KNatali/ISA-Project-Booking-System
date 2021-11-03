package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BoatReport {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private double averageGrade;
	@Column
	private double revenue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public BoatReport(Long id, double averageGrade, double revenue) {
		super();
		this.id = id;
		this.averageGrade = averageGrade;
		this.revenue = revenue;
	}
	public BoatReport() {}
	
}
