package com.douzone.dzfinal.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@PostMapping
	public Map<String,Object> insertPatient(@RequestBody Patient patient) throws Exception{
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
	@ResponseBody
	public List<Patient> searchPatient(
			@RequestParam("patient_name") String patient_name){
		return patientService.searchPatient(patient_name);
	}
//	@GetMapping("/{patient_name}")
//	public Patient searchPatient(
//			@PathVariable("patient_name") String patient_name){
//		return patientService.searchPatient(patient_name);
//	}
//	public List<Patient> searchPatient(
//			@RequestParam("patient_name") String patient_name,
//			@RequestParam("front_registration_number") String front_registration_number,
//			@RequestParam("phone_number3") String phone_number3){
//		Map<String, String> param = new HashMap<>();
//		param.put("patient_name", patient_name);
//		param.put("front_registration_number", front_registration_number);
//		param.put("phone_number3", phone_number3);
//		return patientService.searchPatient(param);
//	}
	
	/*
	 * public int insertPatient(@RequestBody Patient patient) {
	 * 
	 * if(patient != null) { patientService.insertPatient(patient); }else {
	 * 
	 * }
	 * 
	 * return patientService.insertPatient(patient); }
	 */
	
	

}
