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
public class CottageFastReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private LocalDate date;
	@Column(nullable=false)
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
	@Column(name = "reservationStart", nullable = false)
    private LocalDateTime reservationStart;
	@Column(name = "reservationEnd", nullable = false)
    private LocalDateTime reservationEnd;

	
	@OneToMany
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "cottage_id")
	private Cottage cottage;

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

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
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

	public CottageFastReservation(Long id, LocalDateTime reservationStart,
			LocalDateTime reservationEnd, LocalDate date, LocalTime time, int duration, int maxPersons, double price,
			LocalDate validityStart, LocalDate validityEnd, Set<AdditionalItem> additionalItems, Cottage cottage) {
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
		this.cottage = cottage;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
	}
	
	public CottageFastReservation() {}
	
	public CottageFastReservation(Long id, Cottage cottage, LocalDateTime reservationStart,
			LocalDateTime reservationEnd, int maxPersons, double price, LocalDate validityStart, LocalDate validityEnd,
			Set<AdditionalItem> additionalItems) {
		super();
		this.id = id;
		this.cottage = cottage;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.maxPersons = maxPersons;
		this.price = price;
		this.validityStart = validityStart;
		this.validityEnd = validityEnd;
		this.additionalItems = additionalItems;
	}
}
