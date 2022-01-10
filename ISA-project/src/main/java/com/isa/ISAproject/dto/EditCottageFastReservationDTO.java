package com.isa.ISAproject.dto;

public class EditCottageFastReservationDTO {
	private CottageFastReservationDTO action;
	private TimePeriodDTO oldReservationPeriod;
	public CottageFastReservationDTO getAction() {
		return action;
	}
	public void setAction(CottageFastReservationDTO action) {
		this.action = action;
	}
	public TimePeriodDTO getOldReservationPeriod() {
		return oldReservationPeriod;
	}
	public void setOldReservationPeriod(TimePeriodDTO oldReservationPeriod) {
		this.oldReservationPeriod = oldReservationPeriod;
	}
	public EditCottageFastReservationDTO(CottageFastReservationDTO action, TimePeriodDTO oldReservationPeriod) {
		super();
		this.action = action;
		this.oldReservationPeriod = oldReservationPeriod;
	}
	public EditCottageFastReservationDTO() {
		super();
	}
}
