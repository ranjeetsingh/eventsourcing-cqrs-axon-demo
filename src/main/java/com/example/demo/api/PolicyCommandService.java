package com.example.demo.api;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.command.PolicyCanceledCommand;
import com.example.demo.command.PolicyCreatedCommand;
import com.example.demo.command.PolicyUpdatedCommand;
import com.example.demo.cqrs.entity.PolicyEntity;
import com.example.demo.domain.Policy;

@Service
//@Transactional
public class PolicyCommandService {
    private final CommandGateway commandGateway;
    private final EntityManager entityManager;
    private final EventSourcingRepository<Policy> policyEventSourcingRepository;


    public PolicyCommandService(CommandGateway commandGateway, EntityManager entityManager, EventSourcingRepository<Policy> policyEventSourcingRepository) {
        this.commandGateway = commandGateway;
        this.entityManager = entityManager;
        this.policyEventSourcingRepository = policyEventSourcingRepository;
    }

    public List<PolicyEntity>  getAllPolicyEntities() {
        return entityManager.createQuery("select o from PolicyEntity o").getResultList();
    }


    public PolicyEntity  getPolicyEntity(@PathVariable String policyId) {
        return entityManager.find(PolicyEntity.class,policyId);
    }
    @Transactional(propagation = Propagation.NESTED)
    public CompletableFuture<String> createPolicy() {
        return commandGateway.send(new PolicyCreatedCommand(randomId()));
    }


    public CompletableFuture<String> modifyPolicy(@PathVariable String policyId,@RequestBody PolicyUpdatedCommand command) {
        command.setId(policyId);

        return commandGateway.send(command);
    }

    public CompletableFuture<String> cancelPolicy(@PathVariable String policyId, @RequestBody PolicyCanceledCommand command) {

        command.setId(policyId);

        return commandGateway.send(command);
    }


    private String randomId() {
        return UUID.randomUUID().toString();
    }
}
