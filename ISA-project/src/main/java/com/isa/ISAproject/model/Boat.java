package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Boat {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private BoatType type;
	@Column
	private double length;
	@Column
	private String motorNumber;
	@Column
	private double motorPower;
	@Column
	private int maxSpeed;
	@Column
	private String description;
	@ElementCollection
	private List<String> pictures;
	@Column
	private int capacity;
	@Column
	private double grade;
	@ManyToOne
	private BoatOwner owner;
	@OneToMany
	private List<BoatBehavioralRule> boatBehavioralRules;
	@OneToMany
	private List<NavigationEquipment> navigationEquipments;
	@OneToMany
	private List<BoatFastReservation> boatFastReservations;
	@OneToMany
	private List<FishingEquipment> fishingEquipments;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
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
	public String getMotorNumber() {
		return motorNumber;
	}
	public void setMotorNumber(String motorNumber) {
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
	public List<String> getPictures() {
		return pictures;
	}
	public void setPictures(List<String> pictures) {
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
	public List<BoatBehavioralRule> getBoatBehavioralRules() {
		return boatBehavioralRules;
	}
	public void setBoatBehavioralRules(List<BoatBehavioralRule> boatBehavioralRules) {
		this.boatBehavioralRules = boatBehavioralRules;
	}
	public List<NavigationEquipment> getNavigationEquipments() {
		return navigationEquipments;
	}
	public void setNavigationEquipments(List<NavigationEquipment> navigationEquipments) {
		this.navigationEquipments = navigationEquipments;
	}
	public List<BoatFastReservation> getBoatFastReservations() {
		return boatFastReservations;
	}
	public void setBoatFastReservations(List<BoatFastReservation> boatFastReservations) {
		this.boatFastReservations = boatFastReservations;
	}
	public List<FishingEquipment> getFishingEquipments() {
		return fishingEquipments;
	}
	public void setFishingEquipments(List<FishingEquipment> fishingEquipments) {
		this.fishingEquipments = fishingEquipments;
	}
	public Boat(Long id, String name, String address, BoatType type, double length, String motorNumber,
			double motorPower, int maxSpeed, String description, List<String> pictures, int capacity, double grade,
			BoatOwner owner, List<BoatBehavioralRule> boatBehavioralRules,
			List<NavigationEquipment> navigationEquipments, List<BoatFastReservation> boatFastReservations,
			List<FishingEquipment> fishingEquipments) {
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
		this.boatBehavioralRules = boatBehavioralRules;
		this.navigationEquipments = navigationEquipments;
		this.boatFastReservations = boatFastReservations;
		this.fishingEquipments = fishingEquipments;
	}
	
	public Boat () {}
}
