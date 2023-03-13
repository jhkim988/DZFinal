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
public class Diagnosis {
	private int diagnosis_id;
	private String disease_code;
	private int reception_id;
	private int creator;
	private int updator;
	private Timestamp created_at;
	private Timestamp updated_at;
}