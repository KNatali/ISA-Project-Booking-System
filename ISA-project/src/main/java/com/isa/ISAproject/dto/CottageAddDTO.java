package com.isa.ISAproject.dto;

import java.util.HashSet;
import java.util.Set;

public class CottageAddDTO {
	private Long id;
	
	private String name;
	
	private int maxPersons;
	
	private AddressDTO address;
	
	private String description;
	
	private double averageGrade;
	
	private double price;

	private CottageOwnerProfileDTO cottageOwner;


	private String mainPicture;
	
	private int cancellationPercentage;
	
	private Set<CottageBehavioralRuleDTO> rules=new HashSet<>();
	private Set<AdditionalItemDTO> items=new HashSet<>();
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
	public int getMaxPersons() {
		return maxPersons;
	}
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
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
	public double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
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
	public String getMainPicture() {
		return mainPicture;
	}
	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}
	public int getCancellationPercentage() {
		return cancellationPercentage;
	}
	public void setCancellationPercentage(int cancellationPercentage) {
		this.cancellationPercentage = cancellationPercentage;
	}
	public Set<CottageBehavioralRuleDTO> getRules() {
		return rules;
	}
	public void setRules(Set<CottageBehavioralRuleDTO> rules) {
		this.rules = rules;
	}
	public Set<AdditionalItemDTO> getItems() {
		return items;
	}
	public void setItems(Set<AdditionalItemDTO> items) {
		this.items = items;
	}
	public CottageAddDTO(Long id, String name, int maxPersons, AddressDTO address, String description,
			double averageGrade, double price, CottageOwnerProfileDTO cottageOwner, String mainPicture,
			int cancellationPercentage, Set<CottageBehavioralRuleDTO> rules) {
		super();
		this.id = id;
		this.name = name;
		this.maxPersons = maxPersons;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.price = price;
		this.cottageOwner = cottageOwner;
		this.mainPicture = mainPicture;
		this.cancellationPercentage = cancellationPercentage;
		this.rules = rules;
	}
	public CottageAddDTO() {
		super();
	}
	
}
