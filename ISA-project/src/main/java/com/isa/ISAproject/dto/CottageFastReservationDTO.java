package com.isa.ISAproject.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CottageFastReservationDTO {

	private Long id;
	private LocalDateTime reservationStart;
	private LocalDateTime reservationEnd;
	private int duration;
	private int maxPersons;
	private double price;
	private LocalDate validityStart;
	private LocalDate validityEnd;
	private CottageDTO cottage;
	private Set<AdditionalItemDTO> additionalItems=new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(LocalDateTime reservationStart) {
		this.reservationStart = reservationStart;
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
	public LocalDate getValidityStart() {
		return validityStart;
	}
	public void setValidityStart(LocalDate validityStart) {
		this.validityStart = validityStart;
	}
	public LocalDate getValidityEnd() {
		return validityEnd;
	}
	public void setValidityEnd(LocalDate validityEnd) {
		this.validityEnd = validityEnd;
	}
	public CottageDTO getCottage() {
		return cottage;
	}
	public void setCottage(CottageDTO cottage) {
		this.cottage = cottage;
	}
	public Set<AdditionalItemDTO> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItemDTO> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public LocalDateTime getReservationEnd() {
		return reservationEnd;
	}
	public void setReservationEnd(LocalDateTime reservationEnd) {
		this.reservationEnd = reservationEnd;
	}
	public CottageFastReservationDTO(Long id, LocalDateTime reservationStart, LocalDateTime reservationEnd, int duration,
			int maxPersons, double price, LocalDate validityStart, LocalDate validityEnd, CottageDTO cottage,
			Set<AdditionalItemDTO> additionalItems) {
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
		this.additionalItems = additionalItems;
	}
	public CottageFastReservationDTO() {
		super();
	}
}
