package com.example.demo.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import com.example.demo.command.PolicyCanceledCommand;
import com.example.demo.command.PolicyUpdatedCommand;
import com.example.demo.cqrs.entity.PolicyEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This REST API represents the writing side of the application (sending the commands)
 */
@RestController
@Api("Spring BOOT + Axon API")
public class PolicyCommandController {

    private final PolicyCommandService service;

    public PolicyCommandController(PolicyCommandService service) {
        this.service = service;
    }

    @GetMapping("/policies/allentities")
    public List<PolicyEntity> getAllPolicyEntities() {
        return service.getAllPolicyEntities();
    }


    @GetMapping("/policies/{policyId}")
    public PolicyEntity getPolicyEntity(@PathVariable String policyId) {
        return service.getPolicyEntity(policyId);
    }

    @PostMapping("/policies")
    public CompletableFuture<String> createPolicy() {
        return service.createPolicy();
    }


    @PutMapping("/policies/{policyId}/claimamount")
    public CompletableFuture<String> modifyPolicy(@PathVariable String policyId, @RequestBody PolicyUpdatedCommand command) {

        return service.modifyPolicy(policyId, command);
    }

    @PostMapping("/policies/{policyId}/cancellation")
    public CompletableFuture<String> cancelPolicy(@PathVariable String policyId, @RequestBody PolicyCanceledCommand command) {
        return service.cancelPolicy(policyId, command);
    }

}
