package com.isa.ISAproject.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchAvailableCottageByGradeDTO {
	private List<CottageDTO> cottages=new ArrayList<CottageDTO>();
	private double grade;
	public List<CottageDTO> getCottages() {
		return cottages;
	}
	public void setCottages(List<CottageDTO> cottages) {
		this.cottages = cottages;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public SearchAvailableCottageByGradeDTO(List<CottageDTO> cottages, double grade) {
		super();
		this.cottages = cottages;
		this.grade = grade;
	}
	public SearchAvailableCottageByGradeDTO() {}
	
}
