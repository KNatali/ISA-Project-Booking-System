package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Revision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private double grade;
	@Column
	private String revision;
	
	
	
	@Enumerated(EnumType.STRING)
	private RevisionType type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public RevisionType getType() {
		return type;
	}
	public void setType(RevisionType type) {
		this.type = type;
	}
	
	
	public Revision(Long id, double grade, String revision, RevisionType type) {
		super();
		this.id = id;
		this.grade = grade;
		this.revision = revision;
		this.type = type;
		
	}
	public Revision() {
		super();
	}
	
	
}
