package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

public class ReservationResponse {
    @AllArgsConstructor
    @Getter
    public static class Month {
        private String patient_name;
        private String doctor;
        private int count;
        private Date wish_date;
        private String treatment_reason;
    }

    @AllArgsConstructor
    @Getter
    public static class Week {
        private String patient_name;
        private String doctor;
        private int hour_code;
        private int count;
        private Date wish_date;
        private String treatment_reason;
    }

    @AllArgsConstructor
    @Getter
    public static class Day {
        private String patient_name;
        private String doctor;
        private String time;
        private String treatment_reason;
    }
}
