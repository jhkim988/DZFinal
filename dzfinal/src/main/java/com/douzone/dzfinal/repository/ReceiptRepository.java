package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.dto.ReceiptDTO;
import com.douzone.dzfinal.dto.ReceiptDTO.ReceptionInfo;


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
	
	
	
	
	// DTO-처방전 출력 정보 가져오기
	public Optional<ReceiptDTO.TreatmentInfo> getTreatmentInfo(int reception_id);
	// MAP-처방전 출력 정보 가져오기
	public Map<String, Object> getTreatment(String reception_id);

	
	

	// DTO-진료의뢰서 출력 정보 가져오기
	public List<ReceiptDTO.ClinicRequestInfo> getClinicRequestInfo(int patient_id);
	// MAP-진료의뢰서 출력 정보 가져오기
	public List<Map<String, Object>> getClinicRequest(String patient_id);
	
	
	
	
	// DTO-수납완료된 리스트
//	public List<ReceiptDTO.getReceiptList> getReceiptList(int patient_id);
//	// MAP-수납완료된 리스트
//	public List<Map<String, Object>> getReceipt(String patient_id);


}