package com.douzone.dzfinal.entity;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

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
	private String pateint_name;
	private String phone_number1;
	private String phone_number2;
	private String phone_number3;
	private Date wish_date;
	private int time_code;
	private String treatment_reason;
	private String state;
	private int doctor;
	private int creator;
	private int updator;
	
	
}
