package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Adventure {
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
	private double averageGrade;
	@ManyToOne
	private Instructor instructor;
	@ElementCollection//(targetClass=String.class)
	private List<String> pictures; 
	
	private int maxPersons;
	@ManyToMany
	private List<FishingEquipment> equipment;
	@ManyToMany
	private List<BehavioralRule> rules;
	
	private CancellationPolicy cancellation;
	
	public int getMaxPersons() {
		return maxPersons;
	}
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public List<FishingEquipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<FishingEquipment> equipment) {
		this.equipment = equipment;
	}
	public List<BehavioralRule> getRules() {
		return rules;
	}
	public void setRules(List<BehavioralRule> rules) {
		this.rules = rules;
	}
	public CancellationPolicy getCancellation() {
		return cancellation;
	}
	public void setCancellation(CancellationPolicy cancellation) {
		this.cancellation = cancellation;
	}
	public List<String> getPictures() { 
		return pictures; 
	} 
	public void setPictures(List<String> pictures) { 
		this.pictures = pictures; 
	}
	 
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
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
		return averageGrade;
	}
	public void setGrade(double grade) {
		this.averageGrade = grade;
	}
	public Adventure() {}
	public Adventure(Long id, String name, String address, String description, double grade, Instructor instructor,
			List<String> pictures, int maxPersons, List<FishingEquipment> equipment, List<BehavioralRule> rules,
			CancellationPolicy cancellation) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageGrade = grade;
		this.instructor = instructor;
		this.pictures = pictures;
		this.maxPersons = maxPersons;
		this.equipment = equipment;
		this.rules = rules;
		this.cancellation = cancellation;
	}
	
}
