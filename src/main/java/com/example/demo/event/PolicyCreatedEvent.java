package com.example.demo.event;

public class PolicyCreatedEvent extends PolicyEvent {
	String id;
	
	public PolicyCreatedEvent(String id) {
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
