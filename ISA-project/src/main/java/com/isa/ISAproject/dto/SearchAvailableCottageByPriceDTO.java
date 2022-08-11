package com.isa.ISAproject.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchAvailableCottageByPriceDTO {
	private List<CottageDTO> cottages=new ArrayList<CottageDTO>();
	private double price;
	public List<CottageDTO> getCottages() {
		return cottages;
	}
	public void setCottages(List<CottageDTO> cottages) {
		this.cottages = cottages;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public SearchAvailableCottageByPriceDTO(List<CottageDTO> cottages, double price) {
		super();
		this.cottages = cottages;
		this.price = price;
	}
	public SearchAvailableCottageByPriceDTO() {}
}
