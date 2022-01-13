package com.isa.ISAproject.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BoatReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDateTime date;
	//@Column
	//private LocalTime time;
	@Column
	private int duration;
	@Column
	private int maxPersons;
	@OneToMany
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	@Column
	private double price;
	@ManyToOne
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "boat_id")
	private Boat boat;
	@Column(name = "reservationStart", nullable = false)
    private LocalDateTime reservationStart;

    @Column(name = "reservationEnd", nullable = false)
    private LocalDateTime reservationEnd;
    @OneToMany
	private List<BoatComplaint> boatComplaints;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BoatRevision> boatRevisions;
    @OneToOne 
	private BoatReport report;
    
    @OneToOne 
	private BoatOwnerReport ownerReport;
    
    @Column
	private double systemEarning;
	
	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
/*
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
*/
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

	public List<BoatComplaint> getBoatComplaints() {
		return boatComplaints;
	}

	public void setBoatComplaints(List<BoatComplaint> boatComplaints) {
		this.boatComplaints = boatComplaints;
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
	public BoatReport getReport() {
		return report;
	}

	public void setReport(BoatReport report) {
		this.report = report;
	}
	
	public BoatOwnerReport getOwnerReport() {
		return ownerReport;
	}

	public void setOwnerReport(BoatOwnerReport ownerReport) {
		this.ownerReport = ownerReport;
	}
	
	public double getSystemEarning() {
		return systemEarning;
	}

	public void setSystemEarning(double systemEarning) {
		this.systemEarning = systemEarning;
	}
	public List<BoatRevision> getBoatRevisions() {
		return boatRevisions;
	}

	public void setBoatRevisions(List<BoatRevision> boatRevisions) {
		this.boatRevisions = boatRevisions;
	}

	public BoatReservation(Long id, LocalDateTime date, int duration, int maxPersons,
			Set<AdditionalItem> additionalItems, double price, Client client, List<BoatComplaint> boatComplaints,Boat boat) {
		super();
		this.id = id;
		this.date = date;
		//this.time = time;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.additionalItems = additionalItems;
		this.price = price;
		this.client = client;
		this.boatComplaints = boatComplaints;
		this.boat=boat;
	}
	public BoatReservation(Long id, LocalDateTime reservationStart, LocalDateTime reservationEnd,
			Boat boat, int numberOfPersons, double price,
			Set<AdditionalItem> additionalItems, Client client, List<BoatComplaint> boatComplaints,double earning) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.boat = boat;
		this.maxPersons = numberOfPersons;
		this.price = price;
		this.additionalItems = additionalItems;
		this.client = client;
		this.boatComplaints = boatComplaints;
		this.systemEarning=earning;
	}
	
	public BoatReservation() {}
	
	
}
