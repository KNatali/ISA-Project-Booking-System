package com.isa.ISAproject.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class AdventureFastReservation {
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
	@Column
	private double price;
	@Column
	private LocalDate validityStart;
	@Column
	private LocalDate validityEnd;
	@OneToMany
	private List<AdditionalItem> additionalItems;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getValidityStart() {
		return validityStart;
	}
	public void setValidityStart(LocalDate validityStart) {
		this.validityStart = validityStart;
	}
	public LocalDate getValidityEnd() {
		return validityEnd;
	}
	public void setValidityEnd(LocalDate validityEnd) {
		this.validityEnd = validityEnd;
	}
	public List<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(List<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public AdventureFastReservation(Long id, LocalDate date, LocalTime time, int duration, int maxPersons, double price,
			LocalDate validityStart, LocalDate validityEnd, List<AdditionalItem> additionalItems) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.price = price;
		this.validityStart = validityStart;
		this.validityEnd = validityEnd;
		this.additionalItems = additionalItems;
	}
	
	public AdventureFastReservation () {}
}
