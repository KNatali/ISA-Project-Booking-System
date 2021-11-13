package com.isa.ISAproject.dto;



import com.isa.ISAproject.model.Instructor;

public class InstructorProfileDTO {
	
	
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private String city;
	private String mobile;
	
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public InstructorProfileDTO() {}
	public InstructorProfileDTO(String username, String password, String email, String firstName, String lastName,
			String address, String state, String city, String mobile) {
		super();
	
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.city = city;
		this.mobile = mobile;
	}
	public InstructorProfileDTO(Instructor instructor) {
		super();
	
		this.username = instructor.getUsername();
		this.password = instructor.getPassword();
		this.email = instructor.getEmail();
		this.firstName = instructor.getFirstName();
		this.lastName = instructor.getLastName();
		this.address = instructor.getAddress();
		this.state = instructor.getState();
		this.city = instructor.getCity();
		this.mobile = instructor.getMobile();
	}
	
}
