package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.TimePeriod;

public class EditAdventureFastReservationDTO {
	private AdventureFastReservationDTO action;
	private TimePeriodDTO oldReservationPeriod;
	public AdventureFastReservationDTO getAction() {
		return action;
	}
	public void setAction(AdventureFastReservationDTO action) {
		this.action = action;
	}
	public TimePeriodDTO getOldReservationPeriod() {
		return oldReservationPeriod;
	}
	public void setOldReservationPeriod(TimePeriodDTO oldReservationPeriod) {
		this.oldReservationPeriod = oldReservationPeriod;
	}
	public EditAdventureFastReservationDTO(AdventureFastReservationDTO action, TimePeriodDTO oldReservationPeriod) {
		super();
		this.action = action;
		this.oldReservationPeriod = oldReservationPeriod;
	}
	public EditAdventureFastReservationDTO() {
		super();
	}
	
	

}
