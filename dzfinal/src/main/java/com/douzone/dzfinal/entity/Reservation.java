package com.douzone.dzfinal.entity;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
	private int reservation_id;
	private int patient_id;
	private String patient_name;
	private String phone_number1;
	private String phone_number2;
	private String phone_number3;
	private Date wish_date;
	private Time wish_time;
	private String treatment_reason;
	private String state;
	private int doctor;
	private int creator;
	private int updator;
	
	private String employee_name;
	
	private String front_registration_number;
	private String back_registration_number;
	private String zip_code; 
	private String address; 
	private String detail_address;
	private String gender;
	
	
}
