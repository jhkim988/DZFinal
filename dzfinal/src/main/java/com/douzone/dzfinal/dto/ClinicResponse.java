package com.douzone.dzfinal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ClinicResponse {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class Clinic {
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
		private List<DrugTaking> drug_takingList;
		private List<Underlying> underlyingList;
	}
	
	@AllArgsConstructor
	@Data
	public static class DrugTaking {
		private String drug_code;
		private String drug_name;
	}
	
	@AllArgsConstructor
	@Data
	public static class Underlying {
		private String disease_code;
		private String disease_name;
	}
}