package no.simsine.summer25.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {
	@GetMapping("/")
	@ResponseBody
	public String getRoot() {
		return "Hello :)";
	}

	@GetMapping("/testmap")
	@ResponseBody
	public Map<String, String> getTestMap() {
		Map<String, String> testMap = new HashMap<String, String>();
		testMap.put("name", "John");
		testMap.put("surname", "Spring Boot");
		return testMap;
	}
}
