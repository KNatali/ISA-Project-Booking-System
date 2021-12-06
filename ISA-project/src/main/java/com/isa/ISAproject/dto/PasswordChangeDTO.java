package com.isa.ISAproject.dto;

public class PasswordChangeDTO {
private String oldPassword;
	
	private String newPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public PasswordChangeDTO(String oldPassword, String newPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public PasswordChangeDTO() {
		super();
	}
}
