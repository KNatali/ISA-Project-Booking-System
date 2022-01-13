package com.isa.ISAproject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BoatFastReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDate date;
	@Column
	private LocalTime time;
	@Column(nullable=false)
	private int duration;
	@Column(nullable=false)
	private int maxPersons;
	@Column(nullable=false)
	private double price;
	@Column
	private LocalDate validityStart;
	@Column
	private LocalDate validityEnd;
	@OneToMany
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "boat_id")
	private Boat boat;
	@Column(name = "reservationStart", nullable = false)
    private LocalDateTime reservationStart;
	@Column(name = "reservationEnd", nullable = false)
    private LocalDateTime reservationEnd;
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
	public Set<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public Boat getBoat() {
		return boat;
	}
	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	public LocalDateTime getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(LocalDateTime reservationStart) {
		this.reservationStart = reservationStart;
	}
	public LocalDateTime getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(LocalDateTime reservationEnd) {
		this.reservationEnd = reservationEnd;
	}
	public BoatFastReservation(Long id, LocalDate date, LocalTime time, int duration, int maxPersons, double price,
			LocalDate validityStart, LocalDate validityEnd, Set<AdditionalItem> additionalItems, Boat boat) {
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
		this.boat = boat;
	}
	public BoatFastReservation(Long id, Boat boat, LocalDateTime reservationStart,
			LocalDateTime reservationEnd, int maxPersons, double price, LocalDate validityStart, LocalDate validityEnd,
			Set<AdditionalItem> additionalItems) {
		super();
		this.id = id;
		this.boat = boat;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.maxPersons = maxPersons;
		this.price = price;
		this.validityStart = validityStart;
		this.validityEnd = validityEnd;
		this.additionalItems = additionalItems;
	}
	
	public BoatFastReservation () {}
}
