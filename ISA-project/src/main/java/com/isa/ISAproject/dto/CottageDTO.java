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
	private String street;
	private String state;
	private String city;
	private String description;
	private double grade;
	private String mainPicture;
	private AddressDTO address;
	private double price;
	private CottageOwnerProfileDTO cottageOwner;
	private int maxPersons;
	private int cancellationPercentage;
	//private AdditionalItemDTO items;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public CottageOwnerProfileDTO getCottageOwner() {
		return cottageOwner;
	}

	public void setCottageOwner(CottageOwnerProfileDTO cottageOwner) {
		this.cottageOwner = cottageOwner;
	}
	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public int getCancellationPercentage() {
		return cancellationPercentage;
	}

	public void setCancellationPercentage(int cancellationPercentage) {
		this.cancellationPercentage = cancellationPercentage;
	}
	
	/*public AdditionalItemDTO getItems() {
		return items;
	}
	
	public void setItems(AdditionalItemDTO items) {
		this.items = items;
	}*/
	
	public CottageDTO(Long id, String name, String street, String state, String city, String description, double grade,
			String mainPicture) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.state = state;
		this.city = city;
		this.description = description;
		this.grade = grade;
		this.mainPicture = mainPicture;
	}
	public CottageDTO(Cottage cottage) {
		super();
		this.id = cottage.getId();
		this.name =cottage.getName();
		this.street = cottage.getAddress().getStreet();
		this.state = cottage.getAddress().getState();
		this.city = cottage.getAddress().getCity();
		this.description = cottage.getDescription();
		this.grade = cottage.getGrade();
		this.mainPicture = cottage.getMainPicture();
		this.address = new AddressDTO(cottage.getAddress().getId(), cottage.getAddress().getStreet(), cottage.getAddress().getState(), cottage.getAddress().getCity(), cottage.getAddress().getLatitude(), cottage.getAddress().getLongitude());
		this.maxPersons = cottage.getMaxPersons();
		this.price = cottage.getPrice();
		this.cottageOwner = new CottageOwnerProfileDTO(cottage.getCottageOwner());
		this.cancellationPercentage = cottage.getCancellationPercentage(); 
		//this.items = new AdditionalItemDTO();
	}
	
	public CottageDTO(Long id, String name, AddressDTO address, String description, double grade,double price,
			CottageOwnerProfileDTO cottageOwner,String mainPicture,int maxPersons,int cancellation) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
		this.grade = grade;
		this.price=price;
		this.cottageOwner = cottageOwner;
		this.mainPicture=mainPicture;
		this.maxPersons=maxPersons;
		this.id=id;
		this.cancellationPercentage=cancellation;
	}
	
	public CottageDTO() {}
}
