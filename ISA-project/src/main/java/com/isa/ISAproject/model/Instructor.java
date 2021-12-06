package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Instructor extends User{
	@Column
	private double grade;
	
	@OneToMany(mappedBy="instructor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Adventure> adventures=new HashSet<>();
	
	@Column(columnDefinition="LONGTEXT")
	private String biography;
	
	public Set<Adventure> getAdventures() {
		return adventures;
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

	public Instructor() {}
}
