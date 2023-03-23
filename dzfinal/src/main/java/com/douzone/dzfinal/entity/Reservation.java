package com.douzone.dzfinal.entity;

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
	private String phone1;
	private String phone2;
	private String phone3;
	private String wish_date;
	private String wish_time;
	private String treatment_reason;
	private String state;
	private int doctor;
}
