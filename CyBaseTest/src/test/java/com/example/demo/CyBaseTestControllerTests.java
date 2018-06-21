package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.java.rest.keyvalue.controller.KeyValueServiceController;
import com.java.rest.keyvalue.model.KeyValueModel;
import com.java.rest.keyvalue.service.KeyValueService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KeyValueServiceController.class)
public class CyBaseTestControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private KeyValueService serviceClass;

	Map<String, KeyValueModel> map;
	@Autowired
	KeyValueServiceController controller;

	@Before
	public void prepare() {
		serviceClass = new KeyValueService();
		map = new HashMap<>();
	}

	@Test
	public void contextLoads() throws Exception {
		map.put("1", new KeyValueModel("1", "Mukesh"));
		map.put("2", new KeyValueModel("2", "Mrudula"));
		map.put("3", new KeyValueModel("3", "Aniket"));
		map.put("4", new KeyValueModel("4", "Anuj"));
		map.put("5", new KeyValueModel("5", "Pragnesh"));

		mockMvc.perform(post("/servie/allValues").contentType(MediaType.APPLICATION_JSON_VALUE).content("{'key':'1' ,'value' : 'Mukesh'}"));

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
