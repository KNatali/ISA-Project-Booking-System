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

	public Instructor(Set<Adventure> adventures,String biography) {
		super();
		this.adventures = adventures;
		this.biography=biography;
	}
	
	public Instructor() {}
}
