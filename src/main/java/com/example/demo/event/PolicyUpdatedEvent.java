package com.example.demo.event;

public class PolicyUpdatedEvent extends PolicyEvent {
	String id;
	Double claimAmount;
	public PolicyUpdatedEvent(String id,Double claimAmount) {
		super(id);
		this.id= id;
		this.claimAmount = claimAmount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

}
