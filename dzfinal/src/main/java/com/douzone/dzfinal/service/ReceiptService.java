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
	
<<<<<<< HEAD
	public void test1() {
		receiptRepository.test1();
	}
=======
//	public void test1() {
//		receiptRepository.test1();
//	}
>>>>>>> receipt
}