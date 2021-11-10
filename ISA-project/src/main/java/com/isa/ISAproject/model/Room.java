package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int bedsNumber;
	@ManyToOne
	private Cottage cottage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBedsNumber() {
		return bedsNumber;
	}
	public void setBedsNumber(int bedsNumber) {
		this.bedsNumber = bedsNumber;
	}
	public Cottage getCottage() {
		return cottage;
	}
	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}
	public Room(Long id, int bedsNumber, Cottage cottage) {
		super();
		this.id = id;
		this.bedsNumber = bedsNumber;
		this.cottage = cottage;
	}
	
	public Room() {}
	
}
