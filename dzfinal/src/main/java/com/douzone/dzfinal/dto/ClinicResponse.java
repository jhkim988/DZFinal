package com.douzone.dzfinal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

public class ClinicResponse {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class PatientInfo {
		private int reception_id;
		private int patient_id;
		private String patient_name;
		private String front_registration_number;
		private String back_registration_number;
		private int systolic;
		private int diastolic;
		private int blood_sugar;
		private double height;
		private double weight;
		private double bmi;
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
		private String disease_name;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Prescription {
		private int drug_id;
		private String drug_name;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class MedicalInfo {
		private int reception_id;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Timestamp created_at;
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
		private Timestamp start;
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Timestamp end;
		private String keyword;
	}
}