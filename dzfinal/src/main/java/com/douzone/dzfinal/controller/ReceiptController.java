package com.douzone.dzfinal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.ReceiptDTO;
import com.douzone.dzfinal.dto.ReceiptResponse;
import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.entity.Reception;
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
	
	// DTO-수납할 사람들 정보 가져오기
	@GetMapping("/{reception_id}")
	public ReceiptDTO.ReceptionInfo getReceipt(@PathVariable("reception_id") int reception_id) {
		return receiptService.getReceipt(reception_id);
	}
	
	// MAP-수납할 사람들 정보 가져오기
	@GetMapping("/selectReceiptDetail")
	public Map<String, Object> selectReceiptDetail(String reception_id) throws Exception {
		System.out.println(receiptService.selectReceiptDetail(reception_id));
		return receiptService.selectReceiptDetail(reception_id);
	}
	

	
	
	
	

	
	@GetMapping("/list")
	public List<Receipt> receiptList() {
		System.out.println(receiptService.receiptList());
		return receiptService.receiptList();
	}
	


}