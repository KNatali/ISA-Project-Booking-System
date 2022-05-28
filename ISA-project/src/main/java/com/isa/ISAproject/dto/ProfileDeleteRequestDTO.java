package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.ProfileDeleteRequest;
import com.isa.ISAproject.model.ProfileDeleteRequestType;
import com.isa.ISAproject.model.UnavailabilityType;

public class ProfileDeleteRequestDTO {
	private Long id;
	private UserDTO userDTO;
	private String reason;
	private ProfileDeleteRequestType type;
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
	
	
	public ProfileDeleteRequestType getType() {
		return type;
	}
	
	public ProfileDeleteRequestDTO(Long id, UserDTO userDTO, String reason, ProfileDeleteRequestType type) {
		super();
		this.id = id;
		this.userDTO = userDTO;
		this.reason = reason;
		this.type = type;
	}
	public void setType(ProfileDeleteRequestType type) {
		this.type = type;
	}
	public ProfileDeleteRequestDTO() {
		super();
	}

}
