package com.example.demo.cqrs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cqrs.entity.PolicyEntity;

/**
 * Standard JPA repository for accessing the Query Policy entity
 */

public interface PolicyQueryRepository extends JpaRepository<PolicyEntity, String> {
}
