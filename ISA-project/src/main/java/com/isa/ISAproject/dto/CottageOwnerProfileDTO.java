package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.CottageOwner;

public class CottageOwnerProfileDTO {
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
	private String role;
	
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public CottageOwnerProfileDTO() {}
	public CottageOwnerProfileDTO(String username, String password, String email, String firstName, String lastName,
			String street, String state, String city, String mobile,Long id,String role) 
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
		this.role=role;
	}
	public CottageOwnerProfileDTO(CottageOwner cottageOwner)
	{
		super();
	
		this.username = cottageOwner.getUsername();
		this.password = cottageOwner.getPassword();
		this.email = cottageOwner.getEmail();
		this.firstName = cottageOwner.getFirstName();
		this.lastName = cottageOwner.getLastName();
		this.street = cottageOwner.getAddress().getStreet();
		this.state = cottageOwner.getAddress().getState();
		this.city = cottageOwner.getAddress().getCity();
		this.mobile = cottageOwner.getMobile();
		this.id=cottageOwner.getId();
		this.role=cottageOwner.getRole();
		
	}
}
