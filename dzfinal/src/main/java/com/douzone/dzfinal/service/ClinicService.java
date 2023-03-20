package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.dto.ClinicResponse.UnderlyingInsert;
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

	public List<ClinicResponse.DrugTaking> getDrugTaking(String type, String keyword) {
		return clinicRepository.getDrugTaking(type, keyword);
	}

	public List<ClinicResponse.Underlying> getUnderlying(String type, String keyword) {
		return clinicRepository.getUnderlying(type, keyword);
	}

	public void insertUnderlying(ClinicResponse.UnderlyingInsert paramData) {
		clinicRepository.insertUnderlying(paramData);
	}

	public void deleteUnderlying(ClinicResponse.UnderlyingInsert paramData) {
		clinicRepository.deleteUnderlying(paramData);
	}
}