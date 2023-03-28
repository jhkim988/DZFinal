package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaitingDTO {
    private String method;
    private WaitingData data;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class WaitingData {
        private int reception_id;
        private int patient_id;
        private String patient_name;
        private String front_registration_number;
        private int doctor_id;
        private String doctor_name;
        private String state;
    }
}
