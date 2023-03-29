package com.douzone.dzfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.service.ReceiptService;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

	@Autowired
	ReceiptService receiptService;
	
	@GetMapping
	public void test() {
		System.out.println(receiptService.test());
	}
	
//	@GetMapping(value = "/asd")
//	public void test1() {
//		receiptService.test1();
//	}
}