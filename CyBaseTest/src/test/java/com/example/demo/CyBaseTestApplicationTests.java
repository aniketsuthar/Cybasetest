package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.rest.keyvalue.model.KeyValueModel;
import com.java.rest.keyvalue.service.KeyValueService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KeyValueService.class)
public class CyBaseTestApplicationTests {
	KeyValueService serviceClass;
	Map<String, KeyValueModel> map;

	@Before
	public void prepare() {
		serviceClass = new KeyValueService();
		map = new HashMap<>();
	}

	@Test
	public void contextLoads() {
		map.put("1", new KeyValueModel("1", "Mukesh"));
		map.put("2", new KeyValueModel("2", "Mrudula"));
		map.put("3", new KeyValueModel("3", "Aniket"));
		map.put("4", new KeyValueModel("4", "Anuj"));
		map.put("5", new KeyValueModel("5", "Pragnesh"));

		serviceClass.putAll(map);
		System.out.println(serviceClass);
		System.out.println(serviceClass);
		serviceClass.getAll();
		System.out.println(serviceClass);
		System.out.println(serviceClass.get("6"));
		serviceClass.delete("4");
		System.out.println(serviceClass);
		serviceClass.deleteAll();
		System.out.println(serviceClass);
	}

}
