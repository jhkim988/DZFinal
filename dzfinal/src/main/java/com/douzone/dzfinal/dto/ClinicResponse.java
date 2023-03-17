package com.douzone.dzfinal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ClinicResponse {
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
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
		private List<DrugList> drug_takingList;
		private List<DiseaseList> underlyingList;
	}
	
	@AllArgsConstructor
	@Getter
	public static class DrugList {
		private String drug_code;
		private String drug_name;
	}
	
	@AllArgsConstructor
	@Getter
	public static class DiseaseList {
		private String disease_code;
		private String disease_name;
	}
}