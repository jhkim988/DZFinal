package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation {
    private int reservation_id;
    private int patient_id;
    private String patient_name;
    private String phone1;
    private String phone2;
    private String phone3;
    private Date wish_date;
    private Time with_time;
    private String treatment_reason;
    private String state;
    private int doctor;
}
