package com.isa.ISAproject.dto;



import com.isa.ISAproject.model.Instructor;

public class InstructorProfileDTO {
	
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

	private String biography;

	private double grade;

	
	
	
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
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
	
	
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public InstructorProfileDTO() {}
	public InstructorProfileDTO(String username, String password, String email, String firstName, String lastName,

			String street, String state, String city, String mobile,Long id,String role,String biography,double grade) {

			

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
		this.biography=biography;
	this.grade=grade;

	}
	public InstructorProfileDTO(Instructor instructor) {
		super();
	
		this.username = instructor.getUsername();
		this.password = instructor.getPassword();
		this.email = instructor.getEmail();
		this.firstName = instructor.getFirstName();
		this.lastName = instructor.getLastName();
		this.street = instructor.getAddress().getStreet();
		this.state = instructor.getAddress().getState();
		this.city = instructor.getAddress().getCity();
		this.mobile = instructor.getMobile();
		this.id=instructor.getId();
		this.role=instructor.getRole();

		this.biography=instructor.getBiography();

		this.grade=instructor.getGrade();

		
	}
	
}
