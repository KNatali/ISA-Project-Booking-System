package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.RevisionType;

public class RevisionDTO {

	private Long id;
	private double grade;
	private String revision;
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
	
	public RevisionDTO(Long id, double grade, String revision, RevisionType type) {
		super();
		this.id = id;
		this.grade = grade;
		this.revision = revision;
		this.type = type;
		
	}
	public RevisionDTO() {
		super();
	}
	
	
	
}
