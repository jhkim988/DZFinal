package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.dto.ClinicResponse.MedicalInfo;
import com.douzone.dzfinal.repository.ClinicRepository;

@Service
public class ClinicService {
	private final ClinicRepository clinicRepository;
	
	public ClinicService(ClinicRepository clinicRepository) {
		this.clinicRepository = clinicRepository;
	}
	
	public ClinicResponse.PatientInfo getPatientInfo(int reception_id) {
		return clinicRepository.getPatientInfo(reception_id).orElseThrow(IllegalArgumentException::new);
	}

	public List<ClinicResponse.Underlying> getDiseaseList(String type, String keyword) {
		return clinicRepository.getDiseaseList(type, keyword);
	}
	
	public List<ClinicResponse.DrugTaking> getDrugList(String type, String keyword) {
		return clinicRepository.getDrugList(type, keyword);
	}

	public void insertUnderlying(ClinicResponse.Disease paramData) {
		clinicRepository.insertUnderlying(paramData);
	}

	public void deleteUnderlying(int patient_id, int disease_id) {
		clinicRepository.deleteUnderlying(patient_id, disease_id);
	}

	public void insertDrugTaking(ClinicResponse.Drug paramData) {
		clinicRepository.insertDrugTaking(paramData);
	}

	public void deleteDrugTaking(int patient_id, @RequestParam int drug_id) {
		clinicRepository.deleteDrugTaking(patient_id, drug_id);
	}
	
	@Transactional
	public void clinic(ClinicResponse.Clinic paramData) {
		int reception_id = paramData.getReception_id();
		String symptom = paramData.getSymptom();
		boolean treatment = paramData.isTreatment();
		boolean clinic_request = paramData.isClinic_request();
		int creator = paramData.getCreator();
		List<Integer> disease_ids = paramData.getDisease_ids();
		List<Integer> drug_ids = paramData.getDrug_ids();
		
		clinicRepository.insertClinic(reception_id, symptom, treatment, clinic_request, creator);
	    if (disease_ids != null && !disease_ids.isEmpty()) {
	    	clinicRepository.insertDiagnosis(reception_id, disease_ids, creator);
	    }
		if (drug_ids != null && !drug_ids.isEmpty()) {
			clinicRepository.insertPrescription(reception_id, drug_ids);
		}
	}

	public List<ClinicResponse.MedicalRecordInquiry> getMriList(int patient_id) {
		return clinicRepository.getMriList(patient_id);
	}

	public ClinicResponse.MedicalInfo getMedicalInfo(int reception_id) {
		return clinicRepository.getMedicalInfo(reception_id);
	}
}