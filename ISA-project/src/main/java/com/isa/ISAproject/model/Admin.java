package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User{
	@Column
	private boolean major;
}
