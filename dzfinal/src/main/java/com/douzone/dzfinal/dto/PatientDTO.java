package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PatientDTO {
	
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class PhoneNumbers {
        private String phone_number1;
        private String phone_number2;
        private String phone_number3;
    }
    
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class UpdateDailyReservationList{
    	private int reservation_id;
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
    }
}
