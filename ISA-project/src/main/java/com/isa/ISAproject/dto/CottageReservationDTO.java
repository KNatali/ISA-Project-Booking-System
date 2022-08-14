package com.isa.ISAproject.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageComplaint;
import com.isa.ISAproject.model.CottageReservation;

public class CottageReservationDTO {
	private Long id;
	private LocalDateTime date;
	//private LocalTime time;
	private int duration;
	private int maxPersons;
	private double price;
	private ClientProfileDTO client;
	private CottageDTO cottage;
	private String reservationStart;
	private String reservationEnd;
	private CottageOwnerReportDTO report;
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
	}/*
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}*/
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
	public double getSystemEarning() {
		return systemEarning;
	}
	public void setSystemEarning(double systemEarning) {
		this.systemEarning = systemEarning;
	}
	public CottageOwnerReportDTO getReport() {
		return report;
	}
	public void setReport(CottageOwnerReportDTO report) {
		this.report = report;
	}
	public CottageReservationDTO(Long id, LocalDateTime date, int duration, int maxPersons, double price,
			ClientProfileDTO client, CottageDTO cottage) {
		super();
		this.id = id;
		this.date = date;
		//this.time = time;
		this.duration = duration;
		this.maxPersons = maxPersons;
		this.price = price;
		this.client = client;
		this.cottage = cottage;
	}
	public CottageReservationDTO(CottageReservation res) {
		this.id=res.getId();
		this.client=new ClientProfileDTO(res.getClient());
		this.cottage=new CottageDTO(res.getCottage());
		this.date=res.getDate();
		this.reservationStart=res.getReservationStart().toString();
		this.reservationEnd=res.getReservationEnd().toString();
		//this.time=res.getTime();
		this.duration=res.getDuration();
		this.maxPersons=res.getMaxPersons();
		this.price=res.getPrice();
	}
	public CottageReservationDTO() {}

	public CottageReservationDTO(Long id, String reservationStart, String resevationEnd, CottageDTO cottage,
			double price,int persons, ClientProfileDTO client, CottageOwnerReportDTO report, Set<AdditionalItemDTO> additionalItems) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = resevationEnd;
		this.cottage = cottage;
		this.price = price;
		this.maxPersons=persons;
		this.client = client;
		this.report = report;
		this.additionalItems = additionalItems;
	}
	/*public CottageReservationDTO(CottageReservation cottageReservation) {
		super();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		this.id = cottageReservation.getId();
		this.reservationStart = cottageReservation.getReservationStart().format(formatter);
		this.reservationEnd = cottageReservation.getReservationEnd().format(formatter);
		this.cottage = new CottageDTO(cottageReservation.getCottage());
		this.price = cottageReservation.getPrice();
		this.maxPersons=cottageReservation.getMaxPersons();
		this.client = new ClientProfileDTO(cottageReservation.getClient());
	}*/
}
