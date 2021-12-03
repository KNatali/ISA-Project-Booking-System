package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne
    @JoinColumn(name = "adventure_id")
    private Adventure adventure;
	
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
	
	public Adventure getAdventure() {
		return adventure;
	}
	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}
	public AdditionalItem(Long id, String name, double price,Adventure adventure) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.adventure=adventure;
	}
	public AdditionalItem() {}
}
