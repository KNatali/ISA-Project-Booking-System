package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class AdventureFishingEquipment {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "equipment")
	private Set<Adventure> adventures=new HashSet<>();
	@Column
	private String name;

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

	public AdventureFishingEquipment(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public AdventureFishingEquipment() {}
}
