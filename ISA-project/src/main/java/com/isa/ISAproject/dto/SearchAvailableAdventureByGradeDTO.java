package com.isa.ISAproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.ISAproject.model.Adventure;

public class SearchAvailableAdventureByGradeDTO {

	private List<AdventureDTO> adventures=new ArrayList<AdventureDTO>();
	private double grade;
	public List<AdventureDTO> getAdventures() {
		return adventures;
	}
	public void setAdventures(List<AdventureDTO> adventures) {
		this.adventures = adventures;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public SearchAvailableAdventureByGradeDTO(List<AdventureDTO> adventures, double grade) {
		super();
		this.adventures = adventures;
		this.grade = grade;
	}
	public SearchAvailableAdventureByGradeDTO() {}
	
	
}
