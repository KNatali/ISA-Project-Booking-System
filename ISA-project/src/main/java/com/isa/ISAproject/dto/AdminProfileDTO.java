package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.Admin;
import com.isa.ISAproject.model.Instructor;

public class AdminProfileDTO {
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
	public void setStreet(String address) {
		this.street = address;
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
	
	
	

	public AdminProfileDTO() {}
	public AdminProfileDTO(String username, String password, String email, String firstName, String lastName,

			String street, String state, String city, String mobile,Long id,String role) {

			

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
	public AdminProfileDTO(Admin admin) {
		super();
	
		this.username = admin.getUsername();
		this.password = admin.getPassword();
		this.email = admin.getEmail();
		this.firstName = admin.getFirstName();
		this.lastName = admin.getLastName();
		this.street = admin.getAddress().getStreet();
		this.state = admin.getAddress().getState();
		this.city = admin.getAddress().getCity();
		this.mobile = admin.getMobile();
		this.id=admin.getId();
		this.role=admin.getRole();

		
		
	}
}
