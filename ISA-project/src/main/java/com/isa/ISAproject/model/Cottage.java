package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cottage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@ManyToOne
	private Address address;
	@Column(columnDefinition="LONGTEXT")
	private String description;
	@Column(nullable=false)
	private double averageGrade;
	@Column
	private String mainPicture;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private CottageOwner owner;
	@ManyToMany
	 @JoinTable(
	            name = "cottage_pictures",
	            joinColumns = @JoinColumn(name = "cottage_id"),
	            inverseJoinColumns = @JoinColumn(name = "picture_id"))
	private Set<Picture> pictures=new HashSet<>();	
	@ManyToMany
	@JoinTable(name="cottage_and_rules",joinColumns = @JoinColumn(name = "cottage_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "rule_id", referencedColumnName = "id"))
	private Set<CottageBehavioralRule> rules=new HashSet<>();
	@OneToMany(mappedBy="cottage",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Room> rooms=new HashSet<>();
	@OneToMany(mappedBy="cottage")
	private Set<CottageFastReservation> cottageFastReservations;
	@Column
	@Enumerated(EnumType.STRING)
	private CancellationPolicy cancellation;
	@OneToMany
	private Set<CottageReservation> cottageReservations=new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	public Set<CottageBehavioralRule> getBehavioralRules() {
		return rules;
	}

	public void setBehavioralRules(Set<CottageBehavioralRule> behavioralRules) {
		this.rules = behavioralRules;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public CottageOwner getCottageOwner() {
		return owner;
	}

	public void setCottageOwner(CottageOwner cottageOwner) {
		this.owner = cottageOwner;
	}

	public Set<CottageFastReservation> getCottageFastReservations() {
		return cottageFastReservations;
	}

	public void setCottageFastReservations(Set<CottageFastReservation> cottageFastReservations) {
		this.cottageFastReservations = cottageFastReservations;
	}
	

	public String getMainPicture() {
		return mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}
  
	public CancellationPolicy getCancellation() {
		return cancellation;
	}

	public void setCancellation(CancellationPolicy cancellation) {
		this.cancellation = cancellation;
	}
	
	public Cottage(Long id, String name, Address address, String description, double averageGrade, Set<Picture> pictures,
			Set<CottageBehavioralRule> behavioralRules, Set<Room> rooms, CottageOwner cottageOwner,
			Set<CottageFastReservation> cottageFastReservations, String mainPicture,Set<CottageFastReservation> fastReservations,CancellationPolicy cancellation) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.pictures = pictures;
		this.rules = behavioralRules;
		this.rooms = rooms;
		this.owner = cottageOwner;
		this.cottageFastReservations = cottageFastReservations;
		this.mainPicture=mainPicture;
		this.cottageFastReservations=fastReservations;
		this.cancellation = cancellation;
	}
	
	
	public Cottage(Long id, String name, Address address, String description, double grade, String mainPicture,
			CottageOwner owner, Set<String> pictures, Set<CottageBehavioralRule> rules, Set<Room> rooms,
			Set<CottageFastReservation> cottageFastReservations, Set<CottageReservation> cottageReservations) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.grade = grade;
		this.mainPicture = mainPicture;
		this.owner = owner;
		this.pictures = pictures;
		this.rules = rules;
		this.rooms = rooms;
		this.cottageFastReservations = cottageFastReservations;
		this.cottageReservations = cottageReservations;
	}

	public Cottage () {}
}
