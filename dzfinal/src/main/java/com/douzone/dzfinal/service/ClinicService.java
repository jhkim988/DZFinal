package com.douzone.dzfinal.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Clinic;
import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.repository.ClinicRepository;

@Service
public class ClinicService {
	private final ClinicRepository clinicRepository;
	
	public ClinicService(ClinicRepository clinicRepository) {
		this.clinicRepository = clinicRepository;
	}
	
	public Patient getPatient(int reception_id) {
		return clinicRepository.getPatient(reception_id);
	}

	public List<Map<String, String>> getUnderlyingList(int reception_id) {
		return clinicRepository.getUnderlyingList(reception_id);
	}
	
	public List<Map<String, String>> getDrug_TakingList(int reception_id) {
		return clinicRepository.getDrug_TakingList(reception_id);
	}
}