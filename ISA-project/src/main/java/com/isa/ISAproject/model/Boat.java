package com.isa.ISAproject.model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Boat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@ManyToOne
	private Address address;
	@Column
	private BoatType type;
	@Column
	private double length;
	@Column
	private int motorNumber;
	@Column
	private double motorPower;
	@Column
	private int maxSpeed;
	@Column
	private String description;
	@ManyToMany
	 @JoinTable(
	            name = "boat_pictures",
	            joinColumns = @JoinColumn(name = "boat_id"),
	            inverseJoinColumns = @JoinColumn(name = "picture_id"))
	private Set<Picture> pictures=new HashSet<>(); 
	
	

	@Column
	private String mainPicture;//slika koje ce da bude prikazana kada se izlistaju svi brodovi
	@Column
	private double price;
	@Column
	private int capacity;
	@Column
	private double grade;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private BoatOwner owner;
	
	@OneToMany
	private Set<BoatReservation> boatReservations=new HashSet<>();
	
	@Column
	private int maxPersons;
	
	public Set<BoatReservation> getBoatReservations() {
		return boatReservations;
	}
	public void setBoatReservations(Set<BoatReservation> boatReservations) {
		this.boatReservations = boatReservations;
	}
	public Set<BoatBehavioralRule> getRules() {
		return rules;
	}
	public void setRules(Set<BoatBehavioralRule> rules) {
		this.rules = rules;
	}
	public Set<NavigationEquipment> getNavigationEquipment() {
		return navigationEquipment;
	}
	public void setNavigationEquipment(Set<NavigationEquipment> navigationEquipment) {
		this.navigationEquipment = navigationEquipment;
	}

	@ManyToMany
	@JoinTable(name="boat_behavioral_rules",joinColumns = @JoinColumn(name = "boat_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "rule_id", referencedColumnName = "id"))
	private Set<BoatBehavioralRule> rules=new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="boat_navigation_equipment",joinColumns = @JoinColumn(name = "boat_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"))
	private Set<NavigationEquipment> navigationEquipment=new HashSet<>();
	
	@OneToMany(mappedBy="boat",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<BoatFastReservation> boatFastReservations=new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="boat_additional_items",joinColumns = @JoinColumn(name = "boat_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "additional_item_id", referencedColumnName = "id"))
	private Set<AdditionalItem> additionalItems=new HashSet<>();
	@ManyToMany
	@JoinTable(name="boat_subscribers",joinColumns = @JoinColumn(name = "boat_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"))
	private Set<Client> subscribers=new HashSet<>();
	@Column
	private int cancellationPercentage;
	@ManyToMany(cascade =CascadeType.ALL)
	 @JoinTable(
	            name = "boat_unavailability",
	            joinColumns = @JoinColumn(name = "boat_id"),
	            inverseJoinColumns = @JoinColumn(name = "period_id"))
	private Set<TimePeriod> unavailability;


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
	public BoatType getType() {
		return type;
	}
	public void setType(BoatType type) {
		this.type = type;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getMotorNumber() {
		return motorNumber;
	}
	public void setMotorNumber(int motorNumber) {
		this.motorNumber = motorNumber;
	}
	public double getMotorPower() {
		return motorPower;
	}
	public void setMotorPower(double motorPower) {
		this.motorPower = motorPower;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public BoatOwner getOwner() {
		return owner;
	}
	public void setOwner(BoatOwner owner) {
		this.owner = owner;
	}
	public Set<BoatBehavioralRule> getBoatBehavioralRules() {
		return rules;
	}
	public void setBoatBehavioralRules(Set<BoatBehavioralRule> boatBehavioralRules) {
		this.rules = boatBehavioralRules;
	}
	public Set<NavigationEquipment> getNavigationEquipments() {
		return navigationEquipment;
	}
	public void setNavigationEquipments(Set<NavigationEquipment> navigationEquipments) {
		this.navigationEquipment = navigationEquipment;
	}
	public Set<BoatFastReservation> getBoatFastReservations() {
		return boatFastReservations;
	}
	public void setBoatFastReservations(Set<BoatFastReservation> boatFastReservations) {
		this.boatFastReservations = boatFastReservations;
	}
	public String getMainPicture() {
		return mainPicture;
	}
	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
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
	public int getCancellationPercentage() {
		return cancellationPercentage;
	}

	public void setCancellationPercentage(int cancellationPercentage) {
		this.cancellationPercentage = cancellationPercentage;
	}
	public Set<Client> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<Client> subscribes) {
		this.subscribers = subscribes;
	}
	public Set<TimePeriod> getUnavailability() {
		return unavailability;
	}

	public void setUnavailability(Set<TimePeriod> unavailability) {
		this.unavailability = unavailability;
	}
	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public Boat(Long id, String name, Address address, BoatType type, double length, int motorNumber,
			double motorPower, int maxSpeed, String description, Set<Picture> pictures, int capacity, double grade,
			BoatOwner owner, Set<BoatBehavioralRule> boatBehavioralRules,
			Set<NavigationEquipment> navigationEquipment, Set<BoatFastReservation> boatFastReservations, String mainPicture) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
		this.length = length;
		this.motorNumber = motorNumber;
		this.motorPower = motorPower;
		this.maxSpeed = maxSpeed;
		this.description = description;
		this.pictures = pictures;
		this.capacity = capacity;
		this.grade = grade;
		this.owner = owner;
		this.rules = boatBehavioralRules;
		this.navigationEquipment = navigationEquipment;
		this.boatFastReservations = boatFastReservations;
		this.mainPicture=mainPicture;
		
	}
	
	
	public Boat(Long id, String name, Address address, BoatType type, double length, int motorNumber, double motorPower,
			int maxSpeed, int capacity, String description, double grade, double price, BoatOwner owner, String mainPicture, Set<Picture> pictures,
			int maxPersons, Set<BoatBehavioralRule> rules, int cancellation, Set<BoatFastReservation> boatFastReservations, Set<AdditionalItem> items, 
			Set<NavigationEquipment> navigationEquipment, Set<BoatReservation> boatReservations) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
		this.length = length;
		this.motorNumber = motorNumber;
		this.motorPower = motorPower;
		this.maxSpeed = maxSpeed;
		this.capacity=capacity;
		this.description = description;
		this.grade = grade;
		this.price = price;
		this.owner = owner;
		this.mainPicture = mainPicture;
		this.pictures = pictures;
		this.maxPersons = maxPersons;		
		this.boatReservations = boatReservations;
		this.cancellationPercentage = cancellation;
		this.rules = rules;
		this.navigationEquipment = navigationEquipment;
		this.boatFastReservations = boatFastReservations;
		this.additionalItems = items;
	}
	public Boat () {}
}
