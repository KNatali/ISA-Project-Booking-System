package com.isa.ISAproject.dto;

public class CottageOwnerReportDTO {
	private Long id;
	private String content;
	private boolean sanctioned;
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
	public CottageOwnerReportDTO(Long id, String content, boolean sanctioned, boolean showedUp) {
		super();
		this.id = id;
		this.content = content;
		this.sanctioned = sanctioned;
		this.showedUp = showedUp;
	}
	public CottageOwnerReportDTO() {
		super();
	}
}
