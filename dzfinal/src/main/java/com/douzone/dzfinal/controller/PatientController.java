package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.PatientDTO;
import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@PostMapping
	public Map<String,Object> insertPatient(@RequestBody PatientDTO.UpdateDailyReservationList patient) throws Exception{
		Map<String,Object> map = new HashMap<>();
		
		if(patient != null) {
			patientService.insertPatient(patient);
			int patient_id = patientService.getPatientId(patient);
			System.out.println(patient_id);
			map.put("status", "true");
			map.put("message", "회원등록 성공");
			map.put("patient_id", patient_id);
			/* map.put("url", ""); */
		}else {
			map.put("status", "false");
			map.put("message", "회원등록 실패");
		}
		return map;
		
	}
	
	@GetMapping("/{patient_id}")
	public Patient searchPatientInfo(@PathVariable("patient_id") int patient_id) {
		return patientService.searchPatientInfo(patient_id);
	}

	@GetMapping("/list")
	public List<Patient> searchPatient(
			@RequestParam("patient_name") String patient_name){
		return patientService.searchPatient(patient_name);
	}

	@PostMapping("/update")
	public void updatePatientInfo(@RequestBody Patient patient) {
		patientService.updatePatientInfo(patient);
	}
	
	

}
