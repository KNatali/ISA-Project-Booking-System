package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Adventure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@ManyToOne
	private Address address;
	@Column(columnDefinition="LONGTEXT")
	private String description;
	@Column
	private double averageGrade;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Instructor instructor;
	
	@Column
	private double price;

	@Column
	private String mainPicture;
	@ManyToMany
	 @JoinTable(
	            name = "adventure_pictures",
	            joinColumns = @JoinColumn(name = "adventure_id"),
	            inverseJoinColumns = @JoinColumn(name = "picture_id"))
	private Set<Picture> pictures=new HashSet<>(); 
	@Column
	private int maxPersons;
	@ManyToMany
	@JoinTable(name="adventure_equipment",joinColumns = @JoinColumn(name = "adventure_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"))
	private Set<AdventureFishingEquipment> equipment=new HashSet<>();
	@ManyToMany
	@JoinTable(name="adventure_rules",joinColumns = @JoinColumn(name = "adventure_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "rule_id", referencedColumnName = "id"))
	private Set<AdventureBehavioralRule> rules=new HashSet<>();
	
	@Column
	private int cancellationPercentage;

	@OneToMany(mappedBy="adventure",cascade=CascadeType.ALL)
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	 
	@OneToMany(mappedBy = "adventure")
	    private Set<AdventureFastReservation> adventureFastReservations;

	
	public Set<AdventureFastReservation> getAdventureFastReservations() {
		return adventureFastReservations;
	}

	public void setAdventureFastReservations(Set<AdventureFastReservation> adventureFastReservations) {
		this.adventureFastReservations = adventureFastReservations;
	}

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
	public void setMainPicture(String picture) {
		this.mainPicture = picture;
	}

	public String getDescription() {
		return description;
	}
	
	public String getMainPicture() {
		return mainPicture;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

	public Set<AdventureFishingEquipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(Set<AdventureFishingEquipment> equipment) {
		this.equipment = equipment;
	}

	public Set<AdventureBehavioralRule> getRules() {
		return rules;
	}

	public void setRules(Set<AdventureBehavioralRule> rules) {
		this.rules = rules;
	}

	

	public int getCancellationPercentage() {
		return cancellationPercentage;
	}

	public void setCancellationPercentage(int cancellationPercentage) {
		this.cancellationPercentage = cancellationPercentage;
	}

	public Set<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}

	public void setAdditionalItems(Set<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}

	public Adventure(Long id, String name, Address address, String description, double averageGrade,double price,
			Instructor instructor,String mainPicture, Set<Picture> pictures,
			int maxPersons,Set<AdventureFishingEquipment> equipment, Set<AdventureBehavioralRule> rules,
			int cancellation,Set<AdventureFastReservation> fastReservations,Set<AdditionalItem> additionalItems) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.price=price;
		this.instructor = instructor;
		this.mainPicture=mainPicture;
		this.pictures = pictures;
		this.maxPersons = maxPersons;
		this.equipment = equipment;
		this.rules = rules;
		this.cancellationPercentage = cancellation;
		this.adventureFastReservations=fastReservations;
		this.additionalItems=additionalItems;
	}
	
	public Adventure() {}
	
	
}
