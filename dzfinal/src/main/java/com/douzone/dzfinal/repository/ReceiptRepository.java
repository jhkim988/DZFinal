package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.dto.ReceiptDTO;


@Repository
@Mapper
public interface ReceiptRepository {
	
	Receipt test();
	
	// 수납
	public Receipt insertReceipt(Receipt receipt);
	
	// DTO-수납할 사람들 정보 가져오
	public Optional<ReceiptDTO.ReceptionInfo> findOneByReception(int reception_id);
	
	// MAP-수납할 사람들 정보 가져오기
	public Map<String, Object> selectReceiptDetail(String reception_id);
	
//	Optional<ReceiptResponse.Receipt> getReceipt(int receiption_id);
//	List<ReceiptResponse.Patient> getPatient(@Param("patient_id") int patient_id);
//	List<ReceiptResponse.Clinic> getClinic(@Param("clinic_id") int reception_id);
//	List<ReceiptResponse.Reception> getReception(@Param("reception_id") int reception_id);
	// 수납할 사람들 정보 가져오기
//	Object getReceipt(int reception_id);
	
	
	
	
	public List<Receipt> receiptList();
	

	
	
}