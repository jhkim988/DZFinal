package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.ReceiptDTO;
import com.douzone.dzfinal.dto.ReceiptDTO.GetReceiptList;
import com.douzone.dzfinal.dto.ReceiptDTO.ReceptionInfo;
import com.douzone.dzfinal.entity.Receipt;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
@Mapper
public interface ReceiptRepository {
	// 수납
	public void insertReceipt(Receipt receipt);
	// 수납수정
	public void updateReceipt(Receipt receipt);
	// DTO-수납할 사람들 정보 가져오기
	public Optional<ReceiptDTO.ReceptionInfo> findOneByReception(int reception_id);
	// MAP-수납할 사람들 정보 가져오기
	public Map<String, Object> selectReceiptDetail(String reception_id);
	// DTO-약정보 가져오기
	public List<ReceiptDTO.GetDrug> getDrug(int reception_id);
	// DTI-질병정보 가져오기
	public List<ReceiptDTO.GetDisease> getDisease(int reception_id);
//	// DTO-처방전 출력 정보 가져오기
//	public Optional<ReceiptDTO.TreatmentInfo> getTreatmentInfo(int reception_id);
//	// MAP-처방전 출력 정보 가져오기
//	public Map<String, Object> getTreatment(String reception_id);
//	// DTO-진료의뢰서 출력 정보 가져오기
//	public List<ReceiptDTO.ClinicRequestInfo> getClinicRequestInfo(int patient_id);
//	// MAP-진료의뢰서 출력 정보 가져오기
	public List<Map<String, Object>> getClinicRequest(String patient_id);	
	
	Optional<Receipt> findOneByReceptionId(int reception_id);

	// DTO-수납완료내역
	public List<ReceiptDTO.GetReceiptList> getReceiptList(HashMap<String, Object> params);
	// MAP-수납완료내역
	public List<Map<String, Object>> getReceipt(String patient_id);

	
	
	// MAP-수납목록 중 선택한 데이터 하나 가져오기
	public Map<String, Object> selectedOneReceipt(String reception_id);

}