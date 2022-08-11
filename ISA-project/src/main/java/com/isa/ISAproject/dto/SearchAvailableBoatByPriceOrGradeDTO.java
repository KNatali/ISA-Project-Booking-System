package com.isa.ISAproject.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchAvailableBoatByPriceOrGradeDTO {
	private List<BoatDTO> boats=new ArrayList<BoatDTO>();
	private double priceOrGrade;
	public List<BoatDTO> getBoats() {
		return boats;
	}
	public void setBoats(List<BoatDTO> boats) {
		this.boats = boats;
	}
	public double getPriceOrGrade() {
		return priceOrGrade;
	}
	public void setPriceOrGrade(double priceOrGrade) {
		this.priceOrGrade = priceOrGrade;
	}
	public SearchAvailableBoatByPriceOrGradeDTO(List<BoatDTO> boats, double priceOrGrade) {
		super();
		this.boats = boats;
		this.priceOrGrade = priceOrGrade;
	}
	
	public SearchAvailableBoatByPriceOrGradeDTO() {}
}
