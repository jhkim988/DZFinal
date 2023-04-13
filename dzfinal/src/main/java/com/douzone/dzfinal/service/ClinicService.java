package com.douzone.dzfinal.service;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.dto.WaitingDTO;
import com.douzone.dzfinal.repository.ClinicRepository;
import com.douzone.dzfinal.repository.ReceptionRepository;

@Service
public class ClinicService {
	private final ClinicRepository clinicRepository;
	private final MqttMessageService mqttMessageService;
	private final ReceptionRepository receptionRepository;
	public ClinicService(ClinicRepository clinicRepository, MqttMessageService mqttMessageService, ReceptionRepository receptionRepository) {
		this.clinicRepository = clinicRepository;
		this.mqttMessageService = mqttMessageService;
		this.receptionRepository = receptionRepository;;
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
	public void insertClinic(ClinicResponse.Clinic paramData) throws Exception {
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
		
		WaitingDTO.WaitingData waitingData = receptionRepository
				.findReceptionInfoById(reception_id)
				.orElseThrow(IllegalArgumentException::new);
		waitingData.setState("수납대기");
		WaitingDTO waitingDTO = WaitingDTO.builder()
				.method("PUT")
				.data(waitingData)
				.build();
		mqttMessageService.sendToWaiting(waitingDTO);
	}

	@Transactional
	public void updateClinic(ClinicResponse.Clinic paramData) {
		int reception_id = paramData.getReception_id();
		String symptom = paramData.getSymptom();
		boolean treatment = paramData.isTreatment();
		boolean clinic_request = paramData.isClinic_request();
		int creator = paramData.getCreator();
		List<Integer> disease_ids = paramData.getDisease_ids();
		List<Integer> drug_ids = paramData.getDrug_ids();
		
		clinicRepository.updateClinic(reception_id, symptom, treatment, clinic_request, creator);
	    if (disease_ids != null && !disease_ids.isEmpty()) {
	    	clinicRepository.deleteDiagnosis(reception_id);
	    	clinicRepository.insertDiagnosis(reception_id, disease_ids, creator);
	    }
		if (drug_ids != null && !drug_ids.isEmpty()) {
			clinicRepository.deletePrescription(reception_id);
			clinicRepository.insertPrescription(reception_id, drug_ids);
		}
	}

	public List<ClinicResponse.MedicalRecordInquiry> getMriList(int patient_id, ClinicResponse.Pagination pagination) {
		return clinicRepository.getMriList(patient_id, pagination);
	}
	
	public List<ClinicResponse.MedicalRecordInquiry> getSearchMriList(ClinicResponse.SearchInfo searchInfo, ClinicResponse.Pagination pagination) {
		return clinicRepository.getSearchMriList(searchInfo, pagination);
	}

	public ClinicResponse.MedicalInfo getMedicalInfo(int reception_id) {
		return clinicRepository.getMedicalInfo(reception_id);
	}

	public int getTotal(@Digits(integer = 8, fraction = 0) @Min(1) int patient_id) {
		return clinicRepository.getTotal(patient_id);
	}

	public int getSearchTotal(ClinicResponse.SearchInfo searchInfo) {
		return clinicRepository.getSearchTotal(searchInfo);
	}
}