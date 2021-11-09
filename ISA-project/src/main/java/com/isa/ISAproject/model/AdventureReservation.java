package com.isa.ISAproject.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AdventureReservation {
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
	private String place;
	@Column
	private int maxPersons;
	@Column
	private double price;
	@OneToMany
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	@ManyToOne
	private Client client;
	@OneToMany
	private List<AdventureComplaint> adventureComplaints;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public Set<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<AdventureComplaint> getAdventureComplaints() {
		return adventureComplaints;
	}
	public void setAdventureComplaints(List<AdventureComplaint> adventureComplaints) {
		this.adventureComplaints = adventureComplaints;
	}
	public AdventureReservation(Long id, LocalDate date, LocalTime time, int duration, String place, int maxPersons,
			double price, Set<AdditionalItem> additionalItems, Client client,
			List<AdventureComplaint> adventureComplaints) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.place = place;
		this.maxPersons = maxPersons;
		this.price = price;
		this.additionalItems = additionalItems;
		this.client = client;
		this.adventureComplaints = adventureComplaints;
	}
	
	public AdventureReservation() {}
}
