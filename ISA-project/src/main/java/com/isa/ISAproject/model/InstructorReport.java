package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InstructorReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String content;
	@Column 
	private boolean sanctioned;
	@Column
	private boolean showedUp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isSanctioned() {
		return sanctioned;
	}
	public void setSanctioned(boolean sanctioned) {
		this.sanctioned = sanctioned;
	}
	public boolean isShowedUp() {
		return showedUp;
	}
	public void setShowedUp(boolean showedUp) {
		this.showedUp = showedUp;
	}
	public InstructorReport(Long id, String content, boolean sanctioned, boolean showedUp) {
		super();
		this.id = id;
		this.content = content;
		this.sanctioned = sanctioned;
		this.showedUp = showedUp;
	}
	public InstructorReport() {
		super();
	}
	
	
	
}
