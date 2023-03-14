package com.douzone.dzfinal.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	private boolean is_deleted;
}
