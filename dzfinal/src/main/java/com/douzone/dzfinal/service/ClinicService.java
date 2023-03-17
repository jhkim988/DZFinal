package com.douzone.dzfinal.service;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.repository.ClinicRepository;

@Service
public class ClinicService {
	private final ClinicRepository clinicRepository;
	
	public ClinicService(ClinicRepository clinicRepository) {
		this.clinicRepository = clinicRepository;
	}
	
	public ClinicResponse.Clinic getClinic(int reception_id) {
		return clinicRepository.getClinic(reception_id).orElseThrow(IllegalArgumentException::new);
	}
}