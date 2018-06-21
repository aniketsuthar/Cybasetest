package com.java.rest.keyvalue.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.java.rest.keyvalue.model.KeyValueModel;

@Repository
public class KeyValueService {
	private static HashMap<String, KeyValueModel> hashMap;

	public KeyValueService() {
		hashMap = new HashMap<>();
	}

	public synchronized List<KeyValueModel> getAll() {
		Set<Map.Entry<String, KeyValueModel>> entry = hashMap.entrySet();
		List<KeyValueModel> list = new ArrayList<>();
		entry.forEach(s -> list.add(new KeyValueModel(s.getValue().getKey(), s.getValue().getValue())));
		return list;
	}

	public synchronized KeyValueModel get(String key) {
		KeyValueModel value = hashMap.get(key);
		return value;
	}

	public synchronized boolean deleteAll() {
		hashMap.clear();
		return hashMap.isEmpty();
	}

	public synchronized boolean delete(String key) {
		hashMap.remove(key);
		return hashMap.containsKey(key);
	}

	public synchronized void put(String key, KeyValueModel value) {
		hashMap.put(key, value);
	}

	public synchronized void putAll(Map<String, KeyValueModel> map) {
		hashMap.putAll(map);
	}

	@Override
	public String toString() {
		return "KeyValueService [hashMap=" + hashMap + "]";
	}

}
