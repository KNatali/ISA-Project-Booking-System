package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User{
	@Column
	private boolean major;

	public boolean isMajor() {
		return major;
	}

	public void setMajor(boolean major) {
		this.major = major;
	}

	public Admin(boolean major) {
		super();
		this.major = major;
	}
	public Admin() {}
}
