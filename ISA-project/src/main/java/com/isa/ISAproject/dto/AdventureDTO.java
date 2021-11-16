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

	
	private String name;
	
	private String address;
	
	private String description;
	
	private double averageGrade;

	private InstructorProfileDTO instructor;


	private String mainPicture;
	



	

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


	


	public AdventureDTO(Long id, String name, String address, String description, double averageGrade,
			InstructorProfileDTO instructor,String mainPicture) {
		super();
		
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.instructor = instructor;
		this.mainPicture=mainPicture;
		
	}
	
	public AdventureDTO() {}

	public AdventureDTO(Adventure adventure) {
		this.name = adventure.getName();
		
	}
}
