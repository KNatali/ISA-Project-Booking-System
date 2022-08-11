package com.isa.ISAproject.dto;

public class UnsubscribedItemDTO {
    private Long clientIt;
    private Long entityId;
	public Long getClientId() {
		return clientIt;
	}
	public void setClientIt(Long clientIt) {
		this.clientIt = clientIt;
	}
	public Long getEntityId() {
		return entityId;
	}
	public void setEntityIt(Long clientIt) {
		this.entityId = clientIt;
	}
	public UnsubscribedItemDTO(Long clientId, Long clientIt) {
		super();
		this.clientIt = clientId;
		this.entityId = clientIt;
	}
	public UnsubscribedItemDTO() {}
}
