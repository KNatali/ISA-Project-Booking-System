package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.AdditionalItem;

public class AdditionalItemDTO {
	
	private Long id;
	private String name;
	private double price;

public AdditionalItemDTO(){}

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

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public AdditionalItemDTO(Long id, String name, double price) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
}
public AdditionalItemDTO(AdditionalItem item) {
	super();
	this.id = item.getId();
	this.name = item.getName();
	this.price = item.getPrice();
}


	
}
