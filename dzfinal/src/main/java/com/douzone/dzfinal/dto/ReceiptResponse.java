package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class ReceiptResponse {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class Receipt {
		private int receipt_id;
		private int reception_id;
		private double ratio;
		private int total_amount;
		private String card_name;
		private String card_number;
		private String mode;
		private int creator;
		private Timestamp created_at;
	}
	
	@AllArgsConstructor
	@Data
	public static class Clinic {
		private int clinic_id;
		private int reception_id;
		private String symptom;
		private int treatment;
		private int clinic_request;
		private int creator;
		private int updator;
		private Timestamp created_at;
		private Timestamp updated_at;
	}
	
	@AllArgsConstructor
	@Data
	public static class Patient {
		private int patient_id;
		private String patient_name;
		private String phone_number1;
		private String phone_number2;
		private String phone_number3;
		private String front_registration_number;
		private String back_registration_number;
		private String gender;
		private String zip_code;
		private Timestamp address;
		private Timestamp detail_address;
		private int insurance;
		private int creator;
		private int updator;
		private Timestamp created_at;
		private Timestamp updated_at;
		private int is_deleted;
	}
	
	@AllArgsConstructor
	@Data
	public static class Reception {
		private int reception_id;
		private int doctor;
		private String treatment_reason;
		private int patient_id;
		private int creator;
		private int updator;
		private Timestamp created_at;
		private Timestamp updated_at;
		private String state;
		private int systolic;
		private int diastolic;
		private int blood_sugar;
		private double height;
		private double weight;
		private double bmi;
		private int is_deleted;
	}
	
	@AllArgsConstructor
	@Data
	public static class Prescription {
		private int prescription_id;
		private int drug_id;
		private int reception_id;
	}
}