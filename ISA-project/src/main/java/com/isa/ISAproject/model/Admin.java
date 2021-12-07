package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User{
	


	public Admin() {
		super();
		
	}

	public Admin(String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities) {
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
	}
}
