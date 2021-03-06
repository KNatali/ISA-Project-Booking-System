package com.isa.ISAproject.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureBehavioralRule;
import com.isa.ISAproject.model.AdventureFishingEquipment;
import com.isa.ISAproject.model.CancellationPolicy;
import com.isa.ISAproject.model.Instructor;

public class AdventureDTO {

	private Long id;
	
	private String name;
	
	private int maxPersons;
	
	private AddressDTO address;
	
	private String description;
	
	private double averageGrade;
	
	private double price;

	private InstructorProfileDTO instructor;


	private String mainPicture;
	
	private int cancellationPercentage;
	


	
	

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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
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

	public InstructorProfileDTO getInstructor() {
		return instructor;
	}

	public void setInstructor(InstructorProfileDTO instructor) {
		this.instructor = instructor;
	}
	
	

	public int getCancellationPercentage() {
		return cancellationPercentage;
	}

	public void setCancellationPercentage(int cancellationPercentage) {
		this.cancellationPercentage = cancellationPercentage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

	public AdventureDTO(Long id, String name, AddressDTO address, String description, double averageGrade,double price,
			InstructorProfileDTO instructor,String mainPicture,int maxPersons,int cancellation) {
		super();
		
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.price=price;
		this.instructor = instructor;
		this.mainPicture=mainPicture;
		this.maxPersons=maxPersons;
		this.id=id;
		this.cancellationPercentage=cancellation;
	}
	
	public AdventureDTO() {}

	public AdventureDTO(Adventure adventure) {
		this.name = adventure.getName();
		this.address = new AddressDTO(adventure.getAddress());
		this.description = adventure.getDescription();
		this.averageGrade = adventure.getAverageGrade();
		this.price=adventure.getPrice();
		this.instructor = new InstructorProfileDTO(adventure.getInstructor());
		this.mainPicture=adventure.getMainPicture();
		this.maxPersons=adventure.getMaxPersons();
		this.id=adventure.getId();
		this.cancellationPercentage=adventure.getCancellationPercentage();
		
	}
}
