package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

public class ReservationDTO {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Month {
        private String patient_name;
        private String doctor;
        private int count;
        private String wish_date;
        private String treatment_reason;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Week {
        private String patient_name;
        private String doctor;
        private int hour_code;
        private int count;
        private String wish_date;
        private String treatment_reason;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Day {
        private String patient_name;
        private String doctor;
        private String time;
        private String treatment_reason;
    }
}
