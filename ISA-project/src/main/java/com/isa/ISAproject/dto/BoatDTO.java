package com.isa.ISAproject.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.BoatType;

public class BoatDTO {
	private Long id;
	private String name;
	private String street;
	private String state;
	private String city;
	private BoatType type;
	private double length;
	private int motorNumber;
	private double motorPower;
	private int maxSpeed;
	private String description;
	private String mainPicture;//slika koje ce da bude prikazana kada se izlistaju svi brodovi
	private int capacity;
	private double grade;
	//private BoatOwner owner;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getMainPicture() {
		return mainPicture;
	}
	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
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
	public BoatDTO(Long id, String name, String street, String state, String city, BoatType type, double length,
			int motorNumber, double motorPower, int maxSpeed, String description, String mainPicture, int capacity,
			double grade) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.state = state;
		this.city = city;
		this.type = type;
		this.length = length;
		this.motorNumber = motorNumber;
		this.motorPower = motorPower;
		this.maxSpeed = maxSpeed;
		this.description = description;
		this.mainPicture = mainPicture;
		this.capacity = capacity;
		this.grade = grade;
	}
	public BoatDTO(Boat boat) {
		super();
		this.id = boat.getId();
		this.name = boat.getName();
		this.street = boat.getAddress().getStreet();
		this.state = boat.getAddress().getState();
		this.city = boat.getAddress().getCity();
		this.type = boat.getType();
		this.length = boat.getLength();
		this.motorNumber = boat.getMotorNumber();
		this.motorPower = boat.getMotorPower();
		this.maxSpeed = boat.getMaxSpeed();
		this.description = boat.getDescription();
		this.mainPicture = boat.getMainPicture();
		this.capacity = boat.getCapacity();
		this.grade = boat.getGrade();
	}
	public BoatDTO() {}
}
