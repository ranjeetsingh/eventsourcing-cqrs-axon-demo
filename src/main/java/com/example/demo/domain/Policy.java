package com.example.demo.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.demo.command.PolicyCanceledCommand;
import com.example.demo.command.PolicyCreatedCommand;
import com.example.demo.command.PolicyUpdatedCommand;
import com.example.demo.event.PolicyCancelledEvent;
import com.example.demo.event.PolicyCreatedEvent;
import com.example.demo.event.PolicyUpdatedEvent;

import java.io.Serializable;
import java.time.LocalDate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Policy implements Serializable {

    private static final long serialVersionUID = 3775929140935034525L;

    @AggregateIdentifier
    private String id;
    private String policyStartDate;
    private String policyEndDate;
    private PolicyState state;
    private Double claimAmount;


    public Policy() {
    }

    @CommandHandler
    public Policy(PolicyCreatedCommand command) {

        apply(new PolicyCreatedEvent(command.getId()));

    }

    @EventSourcingHandler
    protected void on(PolicyCreatedEvent event) {
        this.id = event.getId();
        this.state = PolicyState.ACTIVE;
        this.policyStartDate = LocalDate.now().toString();
        this.policyEndDate = LocalDate.now().plusYears(1).toString();
    }

    @CommandHandler
    protected void on(PolicyCanceledCommand command) {
        apply(new PolicyCancelledEvent(command.getId(), command.getEndDate()));
    }

    @EventSourcingHandler
    protected void on(PolicyCancelledEvent event) {
        markCancelled();
        this.policyEndDate = event.getEndDate();
    }


    @CommandHandler
    public void on(PolicyUpdatedCommand command) {

        apply(new PolicyUpdatedEvent(command.getId(), command.getClaimAmount()));

    }


    @EventSourcingHandler
    protected void on(PolicyUpdatedEvent event) {
        markUpdated();
        this.claimAmount = event.getClaimAmount();
    }

    public String getId() {
        return id;
    }

    public String getPolicyStartDate() {
        return policyStartDate;
    }

    public String getPolicyEndDate() {
        return policyEndDate;
    }

    public PolicyState getState() {
        return state;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    private void markCancelled() {
        state = PolicyState.CANCELED;
    }

    private void markUpdated() {
        state = PolicyState.UPDATED;
    }

}
