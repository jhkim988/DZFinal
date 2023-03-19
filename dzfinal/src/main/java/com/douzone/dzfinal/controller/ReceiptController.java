package com.douzone.dzfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.service.ReceiptService;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	
	@GetMapping
	public void test() {
		System.out.println(receiptService.test());
	}

	// 수납
	@PostMapping("/insertReceipt")
    public Receipt insertReceipt(@RequestBody Receipt receipt) {
        return receiptService.insertReceipt(receipt);
    }
	

	
	@GetMapping("/list")
	public List<Receipt> receiptList() {
		System.out.println(receiptService.receiptList());
		return receiptService.receiptList();
	}
	


}