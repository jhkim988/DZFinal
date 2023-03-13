package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drug {
	private int drug_id;
	private String drug_code;
	private String drug_name;
	private String drug_standard;
	private String drug_unit;
}