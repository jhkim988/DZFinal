package com.douzone.dzfinal.dto;

import com.douzone.dzfinal.dto.ClinicResponse.MedicalRecordInquiry;
import com.douzone.dzfinal.dto.ClinicResponse.Pagination;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

public class ReceiptDTO {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class ReceptionInfo {
		// (Reception)접수
		private int reception_id;
		private int doctor;
		
		// (Patient)환자
		private int patient_id;
		private String patient_name;
		private boolean insurance;
		private String gender;
		private String front_registration_number;
		private String back_registration_number;
		private String address;
		private String detail_address;
		
		// (Clinic)진료
		private boolean treatment;
		private boolean clinic_request;
		
		// (Prescription)처방
		private boolean has_prescription;
	}
	
	
	
	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class GetDisease {

		// (Reception)진료
		private int reception_id;

		// (Diagnosis)진단
		int diagnosis_id;
		
		// (Disease)질병
		private int disease_id;
		private String disease_code;
		private String disease_name;
		
	}
	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class GetDrug {
		
		// (Reception)진료
		private int reception_id;
		
		// (Prescription)처방
		private int prescription_id;
		
		// (Drug)약품
		private int drug_id;
		private String drug_code;
		private String drug_name;
		
		
	}
	

//	@Data
//	@NoArgsConstructor
//	@AllArgsConstructor
//	@Builder
//	public static class TreatmentInfo {
//		
//		// (Disease)질병
//		private String disease_code;
//		private String disease_name;
//		
//		// (Drug)약품
//		private String drug_code;
//		private String drug_name;
//		
//		// (Diagnosis)진단
//		private Timestamp created_at;
//		
//	}
//	
//
//	@Data
//	@NoArgsConstructor
//	@AllArgsConstructor
//	@Builder
//	public static class ClinicRequestInfo {
//		// (Disease)질병
//		private String disease_code;
//		private String disease_name;
//		
//		// (Drug)약품
//		private String drug_code;
//		private String drug_name;
//		
//		// (Diagnosis)진단
//		private Timestamp created_at;
//	}
	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Diagnosis {
		private int disease_id;
		private String disease_name;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Prescription {
		private int drug_id;
		private String drug_name;
	}

	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class GetReceiptList {
		// (Reception)접수
		private int reception_id;
		private int doctor;
		private String state;

		// (Patient)환자
		private int patient_id;
		private String patient_name;
		private String front_registration_number;
		private String phone_number3;
		
		// (Disease)질병
		private String disease_name;
		
		// (Drug)약품
		private String drug_name;
		
		// (Receipt)수납
		private String mode;
		private int total_amount;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Timestamp created_at;
		
		private int receipt_id;
		private String employee_name;
		private List<Diagnosis> diagnosisList;
		private List<Prescription> prescriptionList;	
		
		private String type;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Timestamp start_date;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Timestamp end_date;
		private String searchText;
		
		private int disease_count;
		private int prescription_count;
		
		
		// 페이징처리
		private int page;
		private int recordSize;
		private int pageSize;
	}
	
	
	
	
	
	
//	@Data
//	@NoArgsConstructor
//	@AllArgsConstructor
//	public static class Pagination {
//		private int startPage; // 시작 페이지 번호
//		private int endPage; // 종료 페이지 번호
//		private int currentPage; // 현재 페이지 번호
//		private int amount;
//		private int total; // 전체 글의 행의 수
//		private boolean prev;
//		private boolean next;
//
//		public Pagination(int currentPage, int amount, int total) {
//			this.currentPage = currentPage;
//			this.amount = amount;
//			this.total = total;
//			this.endPage = (int)Math.ceil(this.currentPage * 0.1) * 10;
//			this.startPage = this.endPage - 10 + 1;
//			int realEnd = (int)Math.ceil(this.total / (double)this.amount);
//			
//			if(this.endPage > realEnd) {
//				this.endPage = realEnd;
//			}
//			if(this.currentPage > realEnd) {
//				this.currentPage = 1;
//			}
//			this.prev = this.startPage > 1;
//			this.next = this.endPage < realEnd;
//		}
//	}
//	
//	@AllArgsConstructor
//	@NoArgsConstructor
//	@Data
//	public static class ㄲPage {
//		private List<MedicalRecordInquiry> mri;
//		private Pagination pagination;
//	}

}