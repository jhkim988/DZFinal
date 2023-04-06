package com.douzone.dzfinal.dto;

import com.douzone.dzfinal.entity.Clinic;
import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.entity.Reception;
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
	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class DetailTodayReservationList {
	    private int patient_id;
	    private String patient_name;
	    private String phone_number1;
	    private String phone_number2;
	    private String phone_number3;
	    private String front_registration_number;
	    private String back_registration_number;
	    private String gender;
	    private String zip_code;
	    private String address;
	    private String detail_address;
	    private boolean insurance;
	    private int creator;
	    private int updater;
		private int reservation_id;
		private String wish_date;
		private String wish_time;
		private String treatment_reason;
		private String state;
		private int doctor;
		private String employee_name;
	}
	
	

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Detail {
		private Reception reception;
		private Patient patient;
		private Receipt receipt;
		private Clinic clinic;
	}
}
