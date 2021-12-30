package com.isa.ISAproject.dto;

public class EmailMessageDTO {
	private String message;
	private String email;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmailMessageDTO(String message, String email) {
		super();
		this.message = message;
		this.email = email;
	}
	public EmailMessageDTO() {
		super();
	}
}
