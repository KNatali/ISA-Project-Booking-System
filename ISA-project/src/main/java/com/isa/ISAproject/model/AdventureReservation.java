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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class AdventureReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @Column(name = "reservationStart", nullable = false)
	    private LocalDateTime reservationStart;

	    @Column(name = "reservationEnd", nullable = false)
	    private LocalDateTime reservationEnd;

	    @ManyToOne
	    @JoinColumn(name = "adventure_id")
	    private Adventure adventure;
	
	@Column(nullable=false)
	private int numberOfPersons;
	@Column(nullable=false)
	private double price;
	@OneToMany
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	@ManyToOne
	private Client client;
	@OneToMany
	private List<AdventureComplaint> adventureComplaints;
	@OneToOne
	private InstructorReport report;
	
	public AdventureReservation(Long id, LocalDateTime reservationStart, LocalDateTime reservationEnd,
			com.isa.ISAproject.model.Adventure adventure, int numberOfPersons, double price,
			Set<AdditionalItem> additionalItems, Client client, List<AdventureComplaint> adventureComplaints) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.adventure = adventure;
		this.numberOfPersons = numberOfPersons;
		this.price = price;
		this.additionalItems = additionalItems;
		this.client = client;
		this.adventureComplaints = adventureComplaints;
	}



	public InstructorReport getReport() {
		return report;
	}



	public void setReport(InstructorReport report) {
		this.report = report;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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



	public Adventure getAdventure() {
		return adventure;
	}



	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}



	public int getNumberOfPersons() {
		return numberOfPersons;
	}



	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
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



	public AdventureReservation() {}
}
