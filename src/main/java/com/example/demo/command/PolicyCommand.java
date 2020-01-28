package com.example.demo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PolicyCommand {
	
	@TargetAggregateIdentifier
	@JsonIgnore
	private String id;

	public PolicyCommand(String id) {
		super();
		this.id = id;
	}
	
	

}
