package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reception {
	private int reception_id;
	private int doctor;
	private String treatment_reason;
	private int patient_id;
	private String patient_name;
	private String phone_number1;
	private String phone_number2;
	private String phone_number3;
	private String front_registration_number;
	private String back_registration_number;
	private String gender;
	private String zip_code;
	private String address;
	private String detail_address;
	private boolean insurance;
	private int creator; 
	private int updator;
	private String state; 
	private int systolic;
	private int diastolic;
	private int blood_sugar;
	private double height;
	private double weight;
	private double bmi;
	private boolean is_deleted;
	
}
