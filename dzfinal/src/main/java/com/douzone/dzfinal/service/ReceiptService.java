package com.douzone.dzfinal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.ReceiptDTO;
import com.douzone.dzfinal.dto.ReceiptDTO.GetReceiptList;
import com.douzone.dzfinal.dto.ReceiptResponse;
import com.douzone.dzfinal.entity.Clinic;
import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.repository.ClinicRepository;
import com.douzone.dzfinal.repository.PatientRepository;
import com.douzone.dzfinal.repository.ReceiptRepository;
import com.douzone.dzfinal.repository.ReceptionRepository;

@Service
public class ReceiptService {
	private final ReceiptRepository receiptRepository;
	
	@Autowired
	private ReceptionRepository receptionRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	
	public ReceiptService(ReceiptRepository receiptRepository) {
		this.receiptRepository = receiptRepository;
	}
	
	// 수납
	public Receipt insertReceipt(Receipt receipt) {
		System.out.println("수납 controller: " + receipt);
		return receiptRepository.insertReceipt(receipt);
	}
	
	
	
	// DTO-수납할 사람들 정보 가져오기
	public ReceiptDTO.ReceptionInfo getReceipt(int reception_id) {
		return receiptRepository.findOneByReception(reception_id).orElseThrow(IllegalArgumentException::new);
	}
	// MAP-수납할 사람들 정보 가져오기
	public Map<String, Object> selectReceiptDetail(String reception_id) throws Exception {
		return receiptRepository.selectReceiptDetail(reception_id);
	}
	
	
	
	
	// DTO-처방전 출력 정보 가져오기
	public ReceiptDTO.TreatmentInfo getTreatmentInfo(int reception_id) {
		return receiptRepository.getTreatmentInfo(reception_id).orElseThrow(IllegalArgumentException::new);
	}
	// MAP-처방전 출력 정보 가져오기
	public Map<String, Object> getTreatment(String reception_id) throws Exception {
		return receiptRepository.getTreatment(reception_id);
	}
	
	
	// DTO-진료의뢰서 출력 정보 가져오기
	public List<ReceiptDTO.ClinicRequestInfo> getClinicRequestInfo(int patient_id) {
		return receiptRepository.getClinicRequestInfo(patient_id);
	}
	// MAP-진료의뢰서 출력 정보 가져오기
	public List<Map<String, Object>> getClinicRequest(String patient_id) throws Exception {
		return receiptRepository.getClinicRequest(patient_id);
	}
	
	
	// DTO-수납완료내역
//	public List<ReceiptDTO.GetReceiptList> getReceiptList(String type, String searchText, String start_date, String end_date) {
//		return receiptRepository.getReceiptList(type, searchText, start_date, end_date);
//	}
	// MAP-수납완료내역
	public List<Map<String, Object>> getReceipt(String patient_id) throws Exception {
		return receiptRepository.getReceipt(patient_id);
	}
	
	

	public Receipt test() {
		return receiptRepository.test();
	}

	public List<GetReceiptList> getReceiptList(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return receiptRepository.getReceiptList(params);
	}
	


}