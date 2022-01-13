package com.isa.ISAproject.dto;

import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.BoatBehavioralRule;
import com.isa.ISAproject.model.BoatFastReservation;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.BoatType;
import com.isa.ISAproject.model.NavigationEquipment;
import com.isa.ISAproject.model.Picture;

public class BoatAddDTO {
private Long id;
	
	private String name;
	
	private int maxPersons;
	
	private AddressDTO address;
	
	private String description;
	
	private double averageGrade;
	
	private double price;

	private BoatOwnerProfileDTO boatOwner;


	private String mainPicture;
	
	private int cancellationPercentage;
	
	private Set<BoatBehavioralRuleDTO> rules=new HashSet<>();
	private Set<AdditionalItemDTO> items=new HashSet<>();
	private BoatType type;
	private double length;
	private int motorNumber;
	private double motorPower;
	private int maxSpeed;
	private int capacity;
	private Set<NavigationEquipmentDTO> equipment = new HashSet<>();
	
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
	public int getMaxPersons() {
		return maxPersons;
	}
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BoatOwnerProfileDTO getBoatOwner() {
		return boatOwner;
	}
	public void setBoatOwner(BoatOwnerProfileDTO boatOwner) {
		this.boatOwner = boatOwner;
	}
	public String getMainPicture() {
		return mainPicture;
	}
	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}
	public int getCancellationPercentage() {
		return cancellationPercentage;
	}
	public void setCancellationPercentage(int cancellationPercentage) {
		this.cancellationPercentage = cancellationPercentage;
	}
	public Set<BoatBehavioralRuleDTO> getRules() {
		return rules;
	}
	public void setRules(Set<BoatBehavioralRuleDTO> rules) {
		this.rules = rules;
	}
	public Set<AdditionalItemDTO> getItems() {
		return items;
	}
	public void setItems(Set<AdditionalItemDTO> items) {
		this.items = items;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Set<NavigationEquipmentDTO> getNavigationEquipment() {
		return equipment;
	}
	public void setNavigationEquipment(Set<NavigationEquipmentDTO> navigationEquipment) {
		this.equipment = navigationEquipment;
	}
	public BoatAddDTO(Long id, String name, int maxPersons, AddressDTO address, String description,
			double averageGrade, double price, BoatOwnerProfileDTO boatOwner, String mainPicture,
			int cancellationPercentage, Set<BoatBehavioralRuleDTO> rules) {
		super();
		this.id = id;
		this.name = name;
		this.maxPersons = maxPersons;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.price = price;
		this.boatOwner = boatOwner;
		this.mainPicture = mainPicture;
		this.cancellationPercentage = cancellationPercentage;
		this.rules = rules;
	}
	public BoatAddDTO() {
		super();
	}
}
