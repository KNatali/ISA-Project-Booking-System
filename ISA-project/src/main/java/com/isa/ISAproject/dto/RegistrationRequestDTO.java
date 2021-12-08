package com.isa.ISAproject.dto;

public class RegistrationRequestDTO {

	private Long id;
	private UserDTO userDTO;
	private String reason;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public RegistrationRequestDTO(Long id, UserDTO userDTO, String reason) {
		super();
		this.id = id;
		this.userDTO = userDTO;
		this.reason = reason;
	}
	public RegistrationRequestDTO() {
		super();
	}
	
	
}
