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
public class Cottage {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String description;
	@Column
	private double grade;
	@ElementCollection
	private List<String> pictures;
	@OneToMany
	private List<CottageBehavioralRule> behavioralRules;
	@OneToMany
	private List<Room> rooms;
	@ManyToOne
	private CottageOwner cottageOwner;
	
	@OneToMany
	private List<CottageFastReservation> cottageFastReservations;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public List<String> getPictures() {
		return pictures;
	}

	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}

	public List<CottageBehavioralRule> getBehavioralRules() {
		return behavioralRules;
	}

	public void setBehavioralRules(List<CottageBehavioralRule> behavioralRules) {
		this.behavioralRules = behavioralRules;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public CottageOwner getCottageOwner() {
		return cottageOwner;
	}

	public void setCottageOwner(CottageOwner cottageOwner) {
		this.cottageOwner = cottageOwner;
	}

	public List<CottageFastReservation> getCottageFastReservations() {
		return cottageFastReservations;
	}

	public void setCottageFastReservations(List<CottageFastReservation> cottageFastReservations) {
		this.cottageFastReservations = cottageFastReservations;
	}

	public Cottage(Long id, String name, String address, String description, double grade, List<String> pictures,
			List<CottageBehavioralRule> behavioralRules, List<Room> rooms, CottageOwner cottageOwner,
			List<CottageFastReservation> cottageFastReservations) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.grade = grade;
		this.pictures = pictures;
		this.behavioralRules = behavioralRules;
		this.rooms = rooms;
		this.cottageOwner = cottageOwner;
		this.cottageFastReservations = cottageFastReservations;
	}
	
	public Cottage () {}
}
