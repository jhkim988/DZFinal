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
public class Reception {
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
	
	private Patient patient;
	private Clinic clinic;
}
