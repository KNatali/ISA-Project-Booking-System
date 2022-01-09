package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.CottageOwner;

public class BoatOwnerProfileDTO {
	private Long id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String street;
	private String state;
	private String city;
	private String mobile;
	private double grade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setAddress(String street) {
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public BoatOwnerProfileDTO() {}
	public BoatOwnerProfileDTO(String username, String password, String email, String firstName, String lastName,
			String street, String state, String city, String mobile,Long id, double grade) 
	{
		super();
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.state = state;
		this.city = city;
		this.mobile = mobile;
		this.id=id;
		this.grade=grade;
	}
	public BoatOwnerProfileDTO(BoatOwner boatOwner)
	{
		super();
		this.username = boatOwner.getUsername();
		this.password = boatOwner.getPassword();
		this.email = boatOwner.getEmail();
		this.firstName = boatOwner.getFirstName();
		this.lastName = boatOwner.getLastName();
		this.street = boatOwner.getAddress().getStreet();
		this.state = boatOwner.getAddress().getState();
		this.city = boatOwner.getAddress().getCity();
		this.mobile = boatOwner.getMobile();
		this.id=boatOwner.getId();
		this.grade=boatOwner.getGrade();
	}
}
