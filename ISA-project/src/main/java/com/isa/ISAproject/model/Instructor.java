package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Instructor extends AppUser{
	@Column
	private double grade;
	
	@OneToMany(mappedBy="instructor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Adventure> adventures=new HashSet<>();
	
	@Column
	private String biography;
	
	@ManyToMany(cascade =CascadeType.ALL)
	 @JoinTable(
	            name = "instructor_unavailability",
	            joinColumns = @JoinColumn(name = "instructor_id"),
	            inverseJoinColumns = @JoinColumn(name = "period_id"))
	private Set<TimePeriod> unavailability;
	
	public Set<Adventure> getAdventures() {
		return adventures;
	}
	
	

	public Set<TimePeriod> getUnavailability() {
		return unavailability;
	}



	public void setUnavailability(Set<TimePeriod> unavailability) {
		this.unavailability = unavailability;
	}



	public String getBiography() {
		return biography;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}


	public void setAdventures(Set<Adventure> adventures) {
		this.adventures = adventures;
	}


	public Instructor(Set<Adventure> adventures,String biography,double grade) {
		super();
		this.adventures = adventures;
		this.biography=biography;
    this.grade=grade;


	}
	
	
	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Instructor(Long id, String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities,double grade,Set<Adventure> adventures,String biography) {
		super(id, username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.grade=grade;
		this.biography=biography;
		this.adventures=adventures;
	}


	public Instructor() {}
}
