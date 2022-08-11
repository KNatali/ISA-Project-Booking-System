package com.isa.ISAproject.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchAvailableAdventureByPriceDTO {
	private List<AdventureDTO> adventures=new ArrayList<AdventureDTO>();
	private double price;
	public List<AdventureDTO> getAdventures() {
		return adventures;
	}
	public void setAdventures(List<AdventureDTO> adventures) {
		this.adventures = adventures;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public SearchAvailableAdventureByPriceDTO(List<AdventureDTO> adventures, double price) {
		super();
		this.adventures = adventures;
		this.price = price;
	}
	public SearchAvailableAdventureByPriceDTO(){}
	
}
