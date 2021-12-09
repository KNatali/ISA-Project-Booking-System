package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User{
	
@Column
private boolean firstLogin;

	public Admin() {
		super();
		
	}
	

	public boolean isFirstLogin() {
		return firstLogin;
	}


	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}


	public Admin(String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities,boolean firstLogin) {
		super();
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setMobile(mobile);
		setEnabled(enabled);
		setRole(role);
		setAuthorities(authorities);
		this.firstLogin=firstLogin;
	}
}
