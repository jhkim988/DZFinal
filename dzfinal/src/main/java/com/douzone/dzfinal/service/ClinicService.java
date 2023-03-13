package com.douzone.dzfinal.service;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Clinic;
import com.douzone.dzfinal.repository.ClinicRepository;

@Service
public class ClinicService {
	private final ClinicRepository clinicRepository;
	
	public ClinicService(ClinicRepository clinicRepository) {
		this.clinicRepository = clinicRepository;
	}
	
	public Clinic test() {
		return clinicRepository.test();
	}
	
	public void test1() {
		clinicRepository.test1();
	}
}