package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReceptionDTO {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class TodayReservationList {
		private int reservation_id;
		private int patient_id;
		private String patient_name;
		private String phone_number1;
		private String phone_number2;
		private String phone_number3;
		private String wish_date;
		private String wish_time;
		private String treatment_reason;
		private String state;
		private int doctor;
		private String employee_name;
	}

}
