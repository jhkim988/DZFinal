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
        private String reservation_id;
        private String patient_name;
        private String doctor;
        private int count;
        private String wish_date;
        private String wish_time;
        private String treatment_reason;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Week {
        private String reservation_id;
        private String patient_name;
        private String doctor;
        private String wish_date;
        private String wish_time;
        private int count;
        private String treatment_reason;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Day {
        private String reservation_id;
        private String patient_name;
        private String doctor;
        private String wish_date;
        private String wish_time;
        private String treatment_reason;
    }
}
