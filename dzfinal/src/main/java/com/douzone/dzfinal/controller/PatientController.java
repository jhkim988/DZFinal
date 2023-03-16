package com.douzone.dzfinal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@PostMapping("/insert")
	public int insertPatient(@RequestBody Patient patient) {
		
//		int result = patientService.insertPatient(patient);
//		if(result!= 0 ) {}
		
		return patientService.insertPatient(patient);
	}
}
