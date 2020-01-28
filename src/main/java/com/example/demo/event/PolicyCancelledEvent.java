package com.example.demo.event;

public class PolicyCancelledEvent extends PolicyEvent {
	
	String id;
	String endDate;

	public PolicyCancelledEvent(String id,String endDate) {
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
