package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
