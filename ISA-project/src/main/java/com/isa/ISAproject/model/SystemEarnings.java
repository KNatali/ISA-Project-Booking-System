package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SystemEarnings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	public static double percentage=10;

	public double getPercentage() {
		return percentage;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SystemEarnings(Long id, double percentage) {
		super();
		this.id = id;
	
	}

	public SystemEarnings() {
		super();
	}
	

}
