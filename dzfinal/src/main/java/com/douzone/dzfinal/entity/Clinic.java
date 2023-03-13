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
public class Clinic {
	private int clinic_id;
	private int reception_id;
	private String symptom;
	private boolean treatment;
	private boolean clinic_request;
	private int creator;
	private int updator;
	private Timestamp created_at;
	private Timestamp updated_at;
}