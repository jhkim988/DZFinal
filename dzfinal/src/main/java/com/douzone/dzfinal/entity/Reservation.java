package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    private int reservation_id;
    private int patient_id;
    private String patient_name;
    private String phone_number1;
    private String phone_number2;
    private String phone_number3;
    private Date with_date;
    private String time;
    private String treatment_reason;
    private String state;
    private String employee_name;
}
