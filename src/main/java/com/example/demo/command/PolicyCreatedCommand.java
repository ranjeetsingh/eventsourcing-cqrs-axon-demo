package com.example.demo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PolicyCreatedCommand extends PolicyCommand{
	@TargetAggregateIdentifier 
	@JsonIgnore 
	String id;
	
	public PolicyCreatedCommand(String id) {
		super(id);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
