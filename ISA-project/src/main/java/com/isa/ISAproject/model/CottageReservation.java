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
public class CottageReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDateTime date;
	//@Column(nullable=false)
	//private LocalTime time;
	@Column
	
	private int duration;
	@Column
	//private int maxPersons;//ovde sam zamenila sa numberOfPersons zato sto se ne poklapa sa frontom
	private int maxPersons;
	@OneToMany
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	@Column
	private double price;
	@ManyToOne
	private Client client;
	@Column(name = "reservationStart", nullable = false)
    private LocalDateTime reservationStart;

    @Column(name = "reservationEnd", nullable = false)
    private LocalDateTime reservationEnd;
	
    @OneToMany
	private List<CottageComplaint> cottageComplaints;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CottageRevision> cottageRevisions;
    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CottageOwnerRevision> cottageOwnerRevisions;
	//
	
	//@Column(name = "reservationStart", nullable = false)
    //private LocalDateTime reservationStart;

    //@Column(name = "reservationEnd", nullable = false)
    //private LocalDateTime reservationEnd;

    @ManyToOne
    @JoinColumn(name = "cottage_id")
    private Cottage cottage;
    
    @OneToOne 
	private CottageReport report;
    
    @OneToOne 
	private CottageOwnerReport ownerReport;
    
    @Column
	private double systemEarning;
    
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
	}*/

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

	public List<CottageComplaint> getCottageComplaints() {
		return cottageComplaints;
	}

	public void setCottageComplaints(List<CottageComplaint> cottageComplaints) {
		this.cottageComplaints = cottageComplaints;
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

	public CottageReport getReport() {
		return report;
	}

	public void setReport(CottageReport report) {
		this.report = report;
	}
	
	public CottageOwnerReport getOwnerReport() {
		return ownerReport;
	}

	public void setOwnerReport(CottageOwnerReport ownerReport) {
		this.ownerReport = ownerReport;
	}
	
	public double getSystemEarning() {
		return systemEarning;
	}

	public void setSystemEarning(double systemEarning) {
		this.systemEarning = systemEarning;
	}
	public List<CottageRevision> getCottageRevisions() {
		return cottageRevisions;
	}

	public void setCottageRevisions(List<CottageRevision> cottageRevisions) {
		this.cottageRevisions = cottageRevisions;
	}
	
	public CottageReservation(Long id, LocalDateTime date, int duration, int maxPersons,
			Set<AdditionalItem> additionalItems, double price, Client client,
			List<CottageComplaint> cottageComplaints,Cottage cottage) {
		super();
		this.id = id;
		this.date = date;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.additionalItems = additionalItems;
		this.price = price;
		this.client = client;
		this.cottageComplaints = cottageComplaints;
		this.cottage=cottage;
	}
	
	public CottageReservation(Long id, LocalDateTime reservationStart, LocalDateTime reservationEnd,
			Cottage cottage, int maxPersons, double price, CottageReport report,
			Set<AdditionalItem> additionalItems, Client client, List<CottageComplaint> cottageComplaints) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.cottage = cottage;
		this.maxPersons = maxPersons;
		this.price = price;
		this.report=report;
		this.additionalItems = additionalItems;
		this.client = client;
		this.cottageComplaints = cottageComplaints;
	}
	
	public CottageReservation() {}
	
	public CottageReservation(Long id, LocalDateTime reservationStart, LocalDateTime reservationEnd,
			Cottage cottage, int numberOfPersons, double price,
			Set<AdditionalItem> additionalItems, Client client, List<CottageComplaint> cottageComplaints,double earning) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.cottage = cottage;
		this.maxPersons = numberOfPersons;
		this.price = price;
		this.additionalItems = additionalItems;
		this.client = client;
		this.cottageComplaints = cottageComplaints;
		this.systemEarning=earning;
	}
}
