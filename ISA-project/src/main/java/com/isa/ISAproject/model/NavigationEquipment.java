package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NavigationEquipment {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	
	@ManyToOne
	private Boat boat;

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

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public NavigationEquipment(Long id, String name, Boat boat) {
		super();
		this.id = id;
		this.name = name;
		this.boat = boat;
	}
	
	public NavigationEquipment() {}
}
