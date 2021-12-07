package com.isa.ISAproject.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Cottage;

public class CottageDTO {
	private Long id;
	private String name;
	private AddressDTO address;
	private String description;
	private double grade;
	private String mainPicture;
	private double price;
	private int maxPersons;
	private CottageOwnerProfileDTO cottageOwner;
	private int cancellation;
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
	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getMainPicture() {
		return mainPicture;
	}
	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public CottageOwnerProfileDTO getCottageOwner() {
		return cottageOwner;
	}

	public void setCottageOwner(CottageOwnerProfileDTO cottageOwner) {
		this.cottageOwner = cottageOwner;
	}
	public int getCancellation() {
		return cancellation;
	}

	public void setCancellation(int cancellation) {
		this.cancellation = cancellation;
	}
	public CottageDTO(Long id, String name, AddressDTO address, String description, double grade,
			double price, CottageOwnerProfileDTO cottageOwner, String mainPicture, int maxPersons,int cancellation) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.grade = grade;
		this.mainPicture = mainPicture;
		this.address = address;
		this.price=price;
		this.cottageOwner = cottageOwner;
		this.maxPersons=maxPersons;
		this.cancellation=cancellation;
	}
	public CottageDTO(Cottage cottage) {
		this.name =cottage.getName();
	}
	public CottageDTO() {}
}
