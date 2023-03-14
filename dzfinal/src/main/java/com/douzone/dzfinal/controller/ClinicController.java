package com.douzone.dzfinal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.service.ClinicService;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {

	@Autowired
	ClinicService clinicService;
	
	@GetMapping("/loadpatient")
	public Map<String, Object> getUnderlyingList(@RequestParam String id) {
		Map<String, Object> resultMap = new HashMap<>();
		
		int reception_id = Integer.parseInt(id);
		
		resultMap.put("patient", clinicService.getPatient(reception_id));
		resultMap.put("underlying", clinicService.getUnderlyingList(reception_id));
		resultMap.put("drug_taking", clinicService.getDrug_TakingList(reception_id));
		
		return resultMap;
	}
}