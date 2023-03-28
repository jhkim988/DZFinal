package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.ReceiptDTO;
import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReceiptService {
	private final ReceiptRepository receiptRepository;
	private final MqttOutboundService mqttOutboundService;
	public ReceiptService(ReceiptRepository receiptRepository, MqttOutboundService mqttOutboundService) {
		this.receiptRepository = receiptRepository;
		this.mqttOutboundService = mqttOutboundService;
	}
	
	// 수납
	public void insertReceipt(Receipt receipt) {
		receiptRepository.insertReceipt(receipt);
		mqttOutboundService.sendToWaiting("PUT", receipt.getReceipt_id(), "수납완료");
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
	public List<ReceiptDTO.GetReceiptList> getReceiptList(int patient_id) {
		return receiptRepository.getReceiptList(patient_id);
	}
	// MAP-수납완료내역
	public List<Map<String, Object>> getReceipt(String patient_id) throws Exception {
		return receiptRepository.getReceipt(patient_id);
	}
}