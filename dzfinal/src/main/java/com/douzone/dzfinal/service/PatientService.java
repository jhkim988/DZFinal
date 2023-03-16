package com.douzone.dzfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	public int insertPatient(Patient patient) {
		return patientRepository.insertPatient(patient);
	}
}
