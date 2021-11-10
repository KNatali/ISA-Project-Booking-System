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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CottageReservation {
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
	@OneToMany
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	@Column(nullable=false)
	private double price;
	@ManyToOne
	private Client client;
	
	@OneToMany
	private Set<CottageComplaint> cottageComplaints=new HashSet<>();

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

	public Set<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}

	public void setAdditionalItems(Set<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<CottageComplaint> getCottageComplaints() {
		return cottageComplaints;
	}

	public void setCottageComplaints(Set<CottageComplaint> cottageComplaints) {
		this.cottageComplaints = cottageComplaints;
	}

	public CottageReservation(Long id, LocalDate date, LocalTime time, int duration, int maxPersons,
			Set<AdditionalItem> additionalItems, double price, Client client,
			Set<CottageComplaint> cottageComplaints) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.additionalItems = additionalItems;
		this.price = price;
		this.client = client;
		this.cottageComplaints = cottageComplaints;
	}
	
	public CottageReservation() {}
}
