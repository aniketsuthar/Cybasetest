package com.java.rest.keyvalue.controller;

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

import com.java.rest.keyvalue.model.KeyValueModel;
import com.java.rest.keyvalue.service.KeyValueService;

@RestController
@RequestMapping("/service")
public class KeyValueServiceController {

	@Autowired
	private KeyValueService service;

	@GetMapping("/allValues")
	public List<KeyValueModel> getAllStoredValues() {
		return service.getAll();
	}

	@GetMapping("/value/{key}")
	public KeyValueModel findValueById(@PathVariable("key") Long key) {
		return service.get(String.valueOf(key));
	}

	@DeleteMapping("/allValues")
	public void deleteAllValues() {
		service.deleteAll();
	}

	@DeleteMapping("/value/{key}")
	public ResponseEntity<Object> deleteValue(@PathVariable("key") Long key) {
		service.delete(String.valueOf(key));
		return ResponseEntity.ok().build();
	}

	@PostMapping("/allValues")
	public void postKeyValues(@RequestBody @Valid KeyValueModel model) {
		service.put(model.getKey(), model);
	}

	@PutMapping("/value/{key}")
	public void putKeyValue(@RequestBody @Valid KeyValueModel model, @PathVariable Long key) {
		KeyValueModel modelToUpdate = service.get(String.valueOf(key));
		modelToUpdate.setValue(model.getValue());
		service.put(String.valueOf(key), modelToUpdate);
	}
}
