package com.isa.ISAproject.dto;

public class ComplaintAnswerDTO {
	private Long id;
	private String  messageClient;
	private String  messageOwner;
	private Long clientId;
	private Long ownerId;
	private String type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessageClient() {
		return messageClient;
	}
	public void setMessageClient(String messageClient) {
		this.messageClient = messageClient;
	}
	public String getMessageOwner() {
		return messageOwner;
	}
	public void setMessageOwner(String messageOwner) {
		this.messageOwner = messageOwner;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public ComplaintAnswerDTO(Long id, String messageClient, String messageOwner, Long clientId, Long ownerId,
			String type) {
		super();
		this.id = id;
		this.messageClient = messageClient;
		this.messageOwner = messageOwner;
		this.clientId = clientId;
		this.ownerId = ownerId;
		this.type = type;
	}
	public ComplaintAnswerDTO() {
		super();
	}

	
}
