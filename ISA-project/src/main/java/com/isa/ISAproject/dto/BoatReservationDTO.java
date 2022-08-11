package com.isa.ISAproject.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.model.BoatReservation;

public class BoatReservationDTO {
	private Long id;
	private LocalDateTime date;
	private int duration;
	private int maxPersons;
	private double price;
	private ClientProfileDTO client;
	private BoatDTO boat;
	private String reservationStart;
	private String reservationEnd;
	private BoatOwnerReportDTO report;
	private double systemEarning;
	private Set<AdditionalItemDTO> additionalItems=new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
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
	public ClientProfileDTO getClient() {
		return client;
	}
	public void setClient(ClientProfileDTO client) {
		this.client = client;
	}
	public BoatDTO getBoat() {
		return boat;
	}
	public void setBoat(BoatDTO boat) {
		this.boat = boat;
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
	public void setReservationEnd(String resevationEnd) {
		this.reservationEnd = resevationEnd;
	}
	public BoatOwnerReportDTO getReport() {
		return report;
	}
	public void setReport(BoatOwnerReportDTO report) {
		this.report = report;
	}
	public Set<AdditionalItemDTO> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItemDTO> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public double getSystemEarning() {
		return systemEarning;
	}
	public void setSystemEarning(double systemEarning) {
		this.systemEarning = systemEarning;
	}
	public BoatReservationDTO(Long id, LocalDateTime date, int duration, int maxPersons, double price,
			ClientProfileDTO client, BoatDTO boat) {
		super();
		this.id = id;
		this.date = date;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.price = price;
		this.client = client;
		this.boat = boat;
	}
	public BoatReservationDTO(BoatReservation res) {
		super();
		this.id = res.getId();
		this.date = res.getDate();
		this.duration = res.getDuration();
		this.maxPersons = res.getMaxPersons();
		this.reservationStart=res.getReservationStart().toString();
		this.price = res.getPrice();
		this.client = new ClientProfileDTO(res.getClient());
		this.boat = new BoatDTO(res.getBoat());
	}
	public BoatReservationDTO(Long id, String reservationStart, String resevationEnd, BoatDTO boat,
			double price,int persons, ClientProfileDTO client, BoatOwnerReportDTO report, Set<AdditionalItemDTO> additionalItems) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = resevationEnd;
		this.boat = boat;
		this.price = price;
		this.maxPersons=persons;
		this.client = client;
		this.report = report;
		this.additionalItems = additionalItems;
	}
	public BoatReservationDTO() {}
}
