package com.isa.ISAproject.dto;

import java.util.HashSet;
import java.util.Set;

public class AdventureAddDTO {
private Long id;
	
	private String name;
	
	private int maxPersons;
	
	private AddressDTO address;
	
	private String description;
	
	private double averageGrade;
	
	private double price;

	private InstructorProfileDTO instructor;


	private String mainPicture;
	
	private int cancellationPercentage;
	
	private Set<AdventureFishingEquipmentDTO> equipment=new HashSet<>();
	private Set<AdditionalItemDTO> additionalItems=new HashSet<>();
	private Set<AdventureBehavioralRuleDTO> rules=new HashSet<>();
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
	public InstructorProfileDTO getInstructor() {
		return instructor;
	}
	public void setInstructor(InstructorProfileDTO instructor) {
		this.instructor = instructor;
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
	public Set<AdventureFishingEquipmentDTO> getEquipment() {
		return equipment;
	}
	public void setEquipment(Set<AdventureFishingEquipmentDTO> equipment) {
		this.equipment = equipment;
	}
	public Set<AdditionalItemDTO> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItemDTO> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public Set<AdventureBehavioralRuleDTO> getRules() {
		return rules;
	}
	public void setRules(Set<AdventureBehavioralRuleDTO> rules) {
		this.rules = rules;
	}
	public AdventureAddDTO(Long id, String name, int maxPersons, AddressDTO address, String description,
			double averageGrade, double price, InstructorProfileDTO instructor, String mainPicture,
			int cancellationPercentage, Set<AdventureFishingEquipmentDTO> equipment,
			Set<AdditionalItemDTO> additionalItems, Set<AdventureBehavioralRuleDTO> rules) {
		super();
		this.id = id;
		this.name = name;
		this.maxPersons = maxPersons;
		this.address = address;
		this.description = description;
		this.averageGrade = averageGrade;
		this.price = price;
		this.instructor = instructor;
		this.mainPicture = mainPicture;
		this.cancellationPercentage = cancellationPercentage;
		this.equipment = equipment;
		this.additionalItems = additionalItems;
		this.rules = rules;
	}
	public AdventureAddDTO() {
		super();
	}
	
	
}
