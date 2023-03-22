package com.douzone.dzfinal.dto;

import java.sql.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReceiptDTO {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class ReceptionInfo {
		// (Reception)접수
		private int reception_id;
		
		// (Patient)환자
		private int patient_id;
		private String patient_name;
		private boolean insurance;
		
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
	public static class TreatmentAndClinicRequestInfo {
		// (Reception)접수
		private int reception_id;
		private int doctor;
		
		// (Patient)환자
		private int patient_id;
		private String patient_name;
		private String gender;
		private String front_registration_number;
		private String back_registration_number;
		private String address;
		private String detail_address;

		// (Drug)약품
		private String drug_code;
		private String drug_name;
		
		// (Disease)질병
		private String disease_code;
		private String disease_name;
		
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class ClinicRequestInfo {
		// (Reception)접수
		private int reception_id;
		
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
		private int doctor;
		
		// (Diagnosis)진단
		private int diagnosis_id;
		private int disease_id;
		// (Disease)질병
		private String disease_code;
		private String disease_name;
		
	}

}
