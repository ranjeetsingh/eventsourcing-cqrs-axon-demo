package com.example.demo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PolicyCanceledCommand extends PolicyCommand {

	@TargetAggregateIdentifier 
	@JsonIgnore 
	String id;
	String endDate;
			
	public PolicyCanceledCommand(String id, String endDate) {
		super(id);
		this.id = id;
		this.endDate = endDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
