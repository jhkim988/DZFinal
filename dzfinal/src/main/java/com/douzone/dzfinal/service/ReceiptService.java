package com.douzone.dzfinal.service;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.repository.ReceiptRepository;

@Service
public class ReceiptService {
	private final ReceiptRepository receiptRepository;
	
	public ReceiptService(ReceiptRepository receiptRepository) {
		this.receiptRepository = receiptRepository;
	}
	
	public Receipt test() {
		return receiptRepository.test();
	}
	
	public void test1() {
		receiptRepository.test1();
	}
}