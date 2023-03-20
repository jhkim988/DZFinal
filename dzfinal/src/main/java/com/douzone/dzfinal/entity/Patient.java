package com.douzone.dzfinal.entity;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
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
	private boolean insurance;
	private int creator;
	private int updator;
	private Timestamp created_at;
	private Timestamp updated_at;
	private boolean is_deleted;
}
