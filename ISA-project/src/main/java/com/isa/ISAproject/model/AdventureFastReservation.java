package com.isa.ISAproject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AdventureFastReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "adventure_id")
    private Adventure adventure;
	
	 @Column(name = "reservationStart", nullable = false)
	    private LocalDateTime reservationStart;

	 @Column
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
	
	
	
	public AdventureFastReservation(Long id, com.isa.ISAproject.model.Adventure adventure, LocalDateTime reservationStart,
			int duration, int maxPersons, double price, LocalDate validityStart, LocalDate validityEnd,
			Set<AdditionalItem> additionalItems) {
		super();
		this.id = id;
		this.adventure = adventure;
		this.reservationStart = reservationStart;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.price = price;
		this.validityStart = validityStart;
		this.validityEnd = validityEnd;
		this.additionalItems = additionalItems;
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Adventure getAdventure() {
		return adventure;
	}



	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}



	public LocalDateTime getReservationStart() {
		return reservationStart;
	}



	public void setReservationStart(LocalDateTime reservationStart) {
		this.reservationStart = reservationStart;
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



	



	public AdventureFastReservation () {}
}
