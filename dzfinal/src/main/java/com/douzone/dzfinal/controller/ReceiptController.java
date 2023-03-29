package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.ReceiptDTO;
import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	
	// 수납
	@PostMapping("/insertReceipt")
    public void insertReceipt(@RequestBody Receipt receipt) {
		receiptService.insertReceipt(receipt);
    }
	
	
	
	// DTO-수납할 사람들 정보 가져오기
	@GetMapping("/findOneByReception/{reception_id}")
	public ReceiptDTO.ReceptionInfo getReceipt(@PathVariable("reception_id") int reception_id) {
		return receiptService.getReceipt(reception_id);
	}
	// MAP-수납할 사람들 정보 가져오기
	@GetMapping("/selectReceiptDetail")
	public Map<String, Object> selectReceiptDetail(String reception_id) throws Exception {
		System.out.println(receiptService.selectReceiptDetail(reception_id));
		return receiptService.selectReceiptDetail(reception_id);
	}
	
	
	
	// DTO-처방전 출력 정보 가져오기
	@GetMapping("/getTreatmentInfo/{reception_id}")
	public ReceiptDTO.TreatmentInfo getTreatmentInfo(@PathVariable("reception_id") int reception_id) {
		return receiptService.getTreatmentInfo(reception_id);
	}
	// MAP-처방전 사람들 정보 가져오기
	@GetMapping("/getTreatment")
	public Map<String, Object> getTreatment(String reception_id) throws Exception {
		System.out.println(receiptService.getTreatment(reception_id));
		return receiptService.getTreatment(reception_id);
	}
	
	
	
	
	
	// DTO-진료의뢰서 출력 정보 가져오기
	@GetMapping("/getClinicRequestInfo/{patient_id}")
	public List<ReceiptDTO.ClinicRequestInfo> getClinicRequestInfo(@PathVariable("patient_id") int patient_id) {
		return receiptService.getClinicRequestInfo(patient_id);
	}
	// MAP-진료의뢰서 사람들 정보 가져오기
	@GetMapping("/getClinicRequest")
	public List<Map<String, Object>> getClinicRequest(String patient_id) throws Exception {
		System.out.println(receiptService.getClinicRequest(patient_id));
		return receiptService.getClinicRequest(patient_id);
	}
	
	
	
	
	// DTO-수납완료내역
	@PostMapping("/getReceiptList")
	public List<ReceiptDTO.GetReceiptList> getReceiptList(@RequestBody HashMap<String,Object> params) {
		//System.out.println(type + searchText + start_date + end_date);
		System.out.println("params: "+params);
		return receiptService.getReceiptList(params);
	}
	// MAP-수납완료내역
	@GetMapping("/getReceipt")
	public List<Map<String, Object>> getReceipt(String patient_id) throws Exception {
		System.out.println(receiptService.getReceipt(patient_id));
		return receiptService.getReceipt(patient_id);
	}

}