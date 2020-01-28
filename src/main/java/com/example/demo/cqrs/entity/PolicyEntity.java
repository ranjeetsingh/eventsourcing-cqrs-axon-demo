package com.example.demo.cqrs.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.domain.PolicyState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * An example of the query side of the Policy Entity
 * <p>
 * In this case it contains the same attributes, but the idea is to create a entity
 * for every query requirement
 */
@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor()
//@EqualsAndHashCode(of = "id")
//@ToString
public class PolicyEntity implements Serializable {

    private static final long serialVersionUID = -6043182657756819128L;
    @Id
    private String id;

    private String policyStartDate;

    private String policyEndDate;

    private PolicyState state;

    private Double claimAmount;

    public PolicyEntity() {
    	
    }

    
    public PolicyEntity(String id) {
        this.id = id;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(String policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public String getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(String policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public PolicyState getState() {
		return state;
	}

	public void setState(PolicyState state) {
		this.state = state;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
