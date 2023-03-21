package com.douzone.dzfinal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	public int insertPatient(Patient patient) {
		int patient_id =patientRepository.insertPatient(patient); 
		return patient_id;
	}
	
	public int getPatientId(Patient patient) {
		return patientRepository.getPatientId(patient);
	}
	
	public List<Patient> searchPatient(String patient_name){
		return patientRepository.searchPatient(patient_name);
	}
	
	public Patient searchPatientInfo(int patient_id) {
		return patientRepository.searchPatientInfo(patient_id).orElseThrow(IllegalArgumentException::new);
	}
	
//	public Patient searchPatient(String patient_name){
//		return patientRepository.searchPatient(patient_name).orElseThrow(IllegalArgumentException::new);
//	}
	
//	public List<Patient> searchPatient(Map<String, String> param){
//		return patientRepository.searchPatient(param);
//	}
	/*
	 * public Patient getOnePatientId(int patient_id) { return
	 * patientRepository.getOnePatientId(patient_id).orElseThrow(
	 * IllegalArgumentException::new); }
	 */
}
