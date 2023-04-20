package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.ReceiptDTO;
import com.douzone.dzfinal.dto.ReceiptDTO.GetDisease;
import com.douzone.dzfinal.dto.ReceiptDTO.GetDrug;
import com.douzone.dzfinal.dto.ReceiptDTO.GetReceiptList;
import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.repository.ReceiptRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReceiptService {
	private final ReceiptRepository receiptRepository;
	private final MqttMessageService mqttMessageService;
	public ReceiptService(ReceiptRepository receiptRepository, MqttMessageService mqttMessageService) {
		this.receiptRepository = receiptRepository;
		this.mqttMessageService = mqttMessageService;
	}

	// 수납
	public void insertReceipt(Receipt receipt) {
		receiptRepository.insertReceipt(receipt);
		mqttMessageService.updateWaitingState(receipt.getReception_id(), "수납완료");
	}
	
	
	
	// 수납 수정
	public void updateReceipt(Receipt receipt) {
		receiptRepository.updateReceipt(receipt);
		
	}
	
	
	

	// DTO-수납할 사람들 정보 가져오기
	public ReceiptDTO.ReceptionInfo getReceipt(int reception_id) {
		return receiptRepository.findOneByReception(reception_id).orElseThrow(IllegalArgumentException::new);
	}
	// MAP-수납할 사람들 정보 가져오기
	public Map<String, Object> selectReceiptDetail(String reception_id) throws Exception {
		return receiptRepository.selectReceiptDetail(reception_id);
	}




	// DTO-약정보 가져오기 
	public List<ReceiptDTO.GetDrug> getDrug(int reception_id) {
		return receiptRepository.getDrug(reception_id);
	}
	// DTO-질병정보 가져오기 
	public List<ReceiptDTO.GetDisease> getDisease(int reception_id) {
		return receiptRepository.getDisease(reception_id);
	}
	
	
	
	
//	// DTO-처방전 출력 정보 가져오기
//	public ReceiptDTO.TreatmentInfo getTreatmentInfo(int reception_id) {
//		return receiptRepository.getTreatmentInfo(reception_id).orElseThrow(IllegalArgumentException::new);
//	}
//	// MAP-처방전 출력 정보 가져오기
//	public Map<String, Object> getTreatment(String reception_id) throws Exception {
//		return receiptRepository.getTreatment(reception_id);
//	}
//
//
//	// DTO-진료의뢰서 출력 정보 가져오기
//	public List<ReceiptDTO.ClinicRequestInfo> getClinicRequestInfo(int patient_id) {
//		return receiptRepository.getClinicRequestInfo(patient_id);
//	}
//	// MAP-진료의뢰서 출력 정보 가져오기
//	public List<Map<String, Object>> getClinicRequest(String patient_id) throws Exception {
//		return receiptRepository.getClinicRequest(patient_id);
//	}


	// DTO-수납완료내역
//	public List<ReceiptDTO.GetReceiptList> getReceiptList(String type, String searchText, String start_date, String end_date) {
//		return receiptRepository.getReceiptList(type, searchText, start_date, end_date);
//	}
	public List<ReceiptDTO.GetReceiptList> getReceiptList(HashMap<String, Object> params) {
		return receiptRepository.getReceiptList(params);
	}

	public int getReceiptListTotalCount(HashMap<String, Object> params) {
		return receiptRepository.getReceiptListTotalCount(params);
	}
	// MAP-수납완료내역
	public List<Map<String, Object>> getReceipt(String patient_id) throws Exception {
		return receiptRepository.getReceipt(patient_id);
	}


	
	
	// MAP-수납목록 중 선택한 데이터 하나 가져오기
	public Map<String, Object> selectedOneReceipt(String reception_id) throws Exception {
		return receiptRepository.selectedOneReceipt(reception_id);
	}




}