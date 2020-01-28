package com.example.demo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PolicyUpdatedCommand extends PolicyCommand{

	@TargetAggregateIdentifier
	@JsonIgnore
	String id;
	Double claimAmount;
			
	public PolicyUpdatedCommand(String id, Double claimAmount) {
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
