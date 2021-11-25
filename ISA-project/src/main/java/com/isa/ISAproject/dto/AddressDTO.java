package com.isa.ISAproject.dto;

import javax.persistence.Column;

public class AddressDTO {
	
	private Long id;
	private String street;
	
	private String state;
	
	private String city;
	
	public AddressDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public AddressDTO(Long id,String street, String state, String city) {
		super();
		this.id=id;
		this.street = street;
		this.state = state;
		this.city = city;
	}
	
}
