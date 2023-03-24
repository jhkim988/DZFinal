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
}
