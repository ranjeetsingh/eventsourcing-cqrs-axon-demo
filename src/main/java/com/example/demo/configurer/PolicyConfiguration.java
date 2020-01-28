package com.example.demo.configurer;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Policy;

@Configuration
public class PolicyConfiguration {

    /**
     * Additionally a repository will be defined for accessing the Policy Aggregate
     */
    @Bean
    public EventSourcingRepository<Policy> policyEventSourcingRepository(EventStore eventStore) {
        return new EventSourcingRepository(Policy.class, eventStore);
    }

}
