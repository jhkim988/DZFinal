package com.douzone.dzfinal.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EchoController {
	
	@PostMapping("/echo")
	public Map<String, Object> echo(@RequestBody Map<String, Object> map) {
		map.put("hi", "bye");
		return map;
	}
}
