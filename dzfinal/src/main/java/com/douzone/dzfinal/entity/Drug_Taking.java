package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drug_Taking {
	private int drug_taking_id;
	private int patient_id;
	private int drug_id;
}