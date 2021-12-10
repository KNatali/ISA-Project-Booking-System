package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String street;
	@Column
	private String state;
	@Column
	private String city;
	@Column
	private double latitude;
	@Column
	private double longitude;
	
	
	
	
	
	
	
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
	
	public Address() {
		
	}
	public Address(Long id, String street, String state, String city, double latitude, double longitude) {
		super();
		this.id = id;
		this.street = street;
		this.state = state;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Address(String street, String state, String city, double latitude, double longitude) {
		super();
		this.street = street;
		this.state = state;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
	
	
}
