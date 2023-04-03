package com.douzone.dzfinal.dto;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ClinicResponse {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class PatientInfo {
		private int reception_id;
		private int patient_id;
		private String patient_name;
//		private String front_registration_number;
//		private String back_registration_number;
		private int systolic;
		private int diastolic;
		private int blood_sugar;
		private double height;
		private double weight;
		private double bmi;
		private String treatment_reason;
		private List<Underlying> underlyingList;
		private List<DrugTaking> drug_takingList;
	}
	
	@AllArgsConstructor
	@Data
	public static class Underlying {
		private int disease_id;
		private String disease_code;
		private String disease_name;
	}
	
	@AllArgsConstructor
	@Data
	public static class DrugTaking {
		private int drug_id;
		private String drug_code;
		private String drug_name;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Disease {
		private int patient_id;
		private int disease_id;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Drug {
		private int patient_id;
		private int drug_id;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Clinic {
		private int reception_id;
		private String symptom;
		private boolean treatment;
		private boolean clinic_request;
		private int creator;
		private List<Integer> disease_ids;
		private List<Integer> drug_ids;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class MedicalRecordInquiry {
		private int reception_id;
		private String patient_name;
		private String employee_name;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Timestamp created_at;
		private List<Diagnosis> diagnosisList;
		private List<Prescription> prescriptionList;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Diagnosis {
		private int disease_id;
		private String disease_code;
		private String disease_name;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Prescription {
		private int drug_id;
		private String drug_code;
		private String drug_name;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Pagination {
		private int startPage; // 시작 페이지 번호
		private int endPage; // 종료 페이지 번호
		private int currentPage; // 현재 페이지 번호
		private int amount;
		private int total; // 전체 글의 행의 수
		private boolean prev;
		private boolean next;

		public Pagination(int currentPage, int amount, int total) {
			this.currentPage = currentPage;
			this.amount = amount;
			this.total = total;
			this.endPage = (int)Math.ceil(this.currentPage * 0.1) * 10;
			this.startPage = this.endPage - 10 + 1;
			int realEnd = (int)Math.ceil(this.total / (double)this.amount);
			
			if(this.endPage > realEnd) {
				this.endPage = realEnd;
			}
			if(this.currentPage > realEnd) {
				this.currentPage = 1;
			}
			this.prev = this.startPage > 1;
			this.next = this.endPage < realEnd;
		}
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class MriPage {
		private List<MedicalRecordInquiry> mri;
		private Pagination pagination;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class MedicalInfo {
		private int reception_id;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Timestamp created_at;
		private String patient_name;
		private String front_registration_number;
		private String employee_name;
		private int systolic;
		private int diastolic;
		private int blood_sugar;
		private double height;
		private double weight;
		private double bmi;
		private String treatment_reason;
		private List<Diagnosis> diagnosis;
		private List<Prescription> prescription;
		private String symptom;
		private boolean treatment;
		private boolean clinic_request;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class SearchInfo {
		private String type;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private String start;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private String end;
		private String keyword;
		private int currentPage;
	}
}