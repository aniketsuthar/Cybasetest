package com.java.rest.keyvalue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.rest.keyvalue.model.AuditRecords;

@Repository
public interface AuditingServiceRepository extends JpaRepository<AuditRecords, Long> {

}
