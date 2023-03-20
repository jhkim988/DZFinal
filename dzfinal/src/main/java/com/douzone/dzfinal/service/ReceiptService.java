package com.douzone.dzfinal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.ReceiptDTO;
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
	
	
	
	

	public Receipt test() {
		return receiptRepository.test();
	}
	


	public List<Receipt> receiptList() {
		return receiptRepository.receiptList();
	}












}