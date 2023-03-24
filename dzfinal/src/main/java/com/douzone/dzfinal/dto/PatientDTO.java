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
        private String phone1;
        private String phone2;
        private String phone3;
    }
}
