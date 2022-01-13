package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class AdditionalItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double price;
	
	@ManyToMany(mappedBy = "additionalItems")
	private Set<Adventure> adventures=new HashSet<>();
	
	@ManyToMany(mappedBy = "items")
	private Set<Cottage> cottages=new HashSet<>();
	
	@ManyToMany(mappedBy = "additionalItems")
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Set<Adventure> getAdventures() {
		return adventures;
	}
	public void SetAdventures(Set<Adventure> adventure) {
		this.adventures = adventure;
	}
	public Set<Cottage> getCottages() {
		return cottages;
	}
	public void SetCottages(Set<Cottage> cottage) {
		this.cottages = cottage;
	}
	public Set<Boat> getBoats() {
		return boats;
	}
	public void SetBoats(Set<Boat> boat) {
		this.boats= boat;
	}
	public AdditionalItem(Long id, String name, double price,Set<Adventure> adventure) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.adventures=adventure;
	}
	public AdditionalItem(Long id, String name, Set<Cottage> cottage, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cottages=cottage;
	}
	public AdditionalItem(Long id, Set<Boat> boat, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.boats=boat;
	}
	public AdditionalItem() {}
}
