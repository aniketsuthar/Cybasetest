package com.java.rest.keyvalue.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.keyvalue.model.AuditRecords;
import com.java.rest.keyvalue.repository.AuditingServiceRepository;

@RestController
@RequestMapping("/audit")
public class KeyValueAuditController {

	@Autowired
	private AuditingServiceRepository service;

	@GetMapping("/allValues")
	public List<AuditRecords> getAllStoredValues() {
		return service.findAll();
	}

	@GetMapping("/value/{id}")
	public AuditRecords findValueById(@PathVariable("id") Long id) {
		return service.findById(id).get();
	}

	@DeleteMapping("/allValues")
	public void deleteAllValues() {
		service.deleteAll();
	}

	@DeleteMapping("/value/{id}")
	public ResponseEntity<Object> deleteValue(@PathVariable("id") Long id) {
		AuditRecords kvModel = service.findById(id).get();
		kvModel.setOperationType("DELETE");
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/allValues")
	public void postKeyValues(@RequestBody @Valid AuditRecords model) {
		model.setTimeStamp(Calendar.getInstance());
		model.setOperationType("CREATE");
		service.save(model);
	}

	@PutMapping("/value/{id}")
	public void putKeyValue(@RequestBody @Valid AuditRecords model, @PathVariable Long key) {
		AuditRecords modelToUpdate = service.findById(key).get();
		modelToUpdate.setValue(model.getValue());
		modelToUpdate.setOperationType("UPDATE");
		modelToUpdate.setTimeStamp(Calendar.getInstance());
		service.save(model);
	}
}
