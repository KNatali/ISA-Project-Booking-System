package com.isa.ISAproject.dto;

import javax.persistence.Column;

import com.isa.ISAproject.model.Address;

public class AddressDTO {
	
	private Long id;
	private String street;
	
	private String state;
	
	private String city;
	
	private double latitude;
	private double longitude;
	
	public AddressDTO() {
		
	}
	
	

	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
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

	public AddressDTO(Long id,String street, String state, String city,double latitude,double longitude) {
		super();
		this.id=id;
		this.street = street;
		this.state = state;
		this.city = city;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public AddressDTO(Address address) {
		super();
		this.id=address.getId();
		this.street = address.getStreet();
		this.state = address.getState();
		this.city = address.getCity();
	}
	
}
