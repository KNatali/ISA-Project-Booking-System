package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class NavigationEquipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	
	@ManyToMany(mappedBy="navigationEquipment")
	private Set<Boat> boats=new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Boat> getBoat() {
		return boats;
	}

	public void setBoat(Set<Boat> boats) {
		this.boats = boats;
	}

	public NavigationEquipment(Long id, String name, Set<Boat> boats) {
		super();
		this.id = id;
		this.name = name;
		this.boats = boats;
	}
	
	public NavigationEquipment() {}
}
