package com.example.demo;

import org.axonframework.eventhandling.saga.repository.jpa.SagaEntry;
import org.axonframework.eventsourcing.eventstore.jpa.DomainEventEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.cqrs.entity.PolicyEntity;

//@SpringBootApplication
@SpringBootApplication
@EnableJpaRepositories
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EntityScan(basePackageClasses = {SagaEntry.class, PolicyEntity.class,DomainEventEntry.class})
//@EntityScan(basePackageClasses = {PolicyEntity.class,DomainEventEntry.class})
//@EnableTransactionManagement(proxyTargetClass = true)
public class CqrsEventSourcingUsingAxonIqMasterApplication {

	//https://github.com/mgorav/EventDrivenMicroServiceUsingAxonIQ
	
	public static void main(String[] args) {
		SpringApplication.run(CqrsEventSourcingUsingAxonIqMasterApplication.class, args);
		System.setProperty("spring.devtools.restart.enabled", "false");
		System.out.println("Application start......!!");
	}

}
