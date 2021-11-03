package com.isa.ISAproject.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.print.attribute.standard.DateTimeAtCompleted;

@Entity
public class BoatReservation {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private LocalDate date;
	@Column
	private LocalTime time;
	@Column
	private int duration;
	@Column
	private int maxPersons;
	@ElementCollection
	private List<String> benefits;
	@Column
	private double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getMaxPersons() {
		return maxPersons;
	}
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public List<String> getBenefits() {
		return benefits;
	}
	public void setBenefits(List<String> benefits) {
		this.benefits = benefits;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BoatReservation(Long id, LocalDate date, LocalTime time, int duration, int maxPersons, List<String> benefits,
			double price) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.benefits = benefits;
		this.price = price;
	}
	
	public BoatReservation() {}
	
	
}
