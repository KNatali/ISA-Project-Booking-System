package com.isa.ISAproject.dto;

import java.util.HashSet;
import java.util.Set;

public class ReserveCottageFastReservation {
	private Long id;
	private String reservationStart;
	private String reservationEnd;
	private int duration;
	private int maxPersons;
	private double price;
	private String validityStart;
	private String validityEnd;
	private CottageDTO cottage;
	private ClientProfileDTO client;
	private Set<AdditionalItemDTO> additionalItems=new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(String reservationStart) {
		this.reservationStart = reservationStart;
	}
	public String getReservationEnd() {
		return reservationEnd;
	}
	public void setReservationEnd(String reservationEnd) {
		this.reservationEnd = reservationEnd;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getMaxPersons() {
		return maxPersons;
	}
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getValidityStart() {
		return validityStart;
	}
	public void setValidityStart(String validityStart) {
		this.validityStart = validityStart;
	}
	public String getValidityEnd() {
		return validityEnd;
	}
	public void setValidityEnd(String validityEnd) {
		this.validityEnd = validityEnd;
	}
	public CottageDTO getCottage() {
		return cottage;
	}
	public void setCottage(CottageDTO cottage) {
		this.cottage = cottage;
	}
	public ClientProfileDTO getClient() {
		return client;
	}
	public void setClient(ClientProfileDTO client) {
		this.client = client;
	}
	public Set<AdditionalItemDTO> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItemDTO> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public ReserveCottageFastReservation(Long id, String reservationStart, String reservationEnd, int duration,
			int maxPersons, double price, String validityStart, String validityEnd, CottageDTO cottage,
			ClientProfileDTO client, Set<AdditionalItemDTO> additionalItems) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.price = price;
		this.validityStart = validityStart;
		this.validityEnd = validityEnd;
		this.cottage = cottage;
		this.client = client;
		this.additionalItems = additionalItems;
	}
	public ReserveCottageFastReservation() {}
	
}
