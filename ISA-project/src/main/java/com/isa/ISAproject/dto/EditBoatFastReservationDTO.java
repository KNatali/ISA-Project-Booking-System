package com.isa.ISAproject.dto;

public class EditBoatFastReservationDTO {
	private BoatFastReservationDTO action;
	private TimePeriodDTO oldReservationPeriod;
	public BoatFastReservationDTO getAction() {
		return action;
	}
	public void setAction(BoatFastReservationDTO action) {
		this.action = action;
	}
	public TimePeriodDTO getOldReservationPeriod() {
		return oldReservationPeriod;
	}
	public void setOldReservationPeriod(TimePeriodDTO oldReservationPeriod) {
		this.oldReservationPeriod = oldReservationPeriod;
	}
	public EditBoatFastReservationDTO(BoatFastReservationDTO action, TimePeriodDTO oldReservationPeriod) {
		super();
		this.action = action;
		this.oldReservationPeriod = oldReservationPeriod;
	}
	public EditBoatFastReservationDTO() {
		super();
	}
}
