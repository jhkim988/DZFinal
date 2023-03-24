package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private int patient_id;
    private String patient_name;
    private String phone1;
    private String phone2;
    private String phone3;
    private String front_registration_number;
    private String back_registration_number;
    private String gender;
    private String zip;
    private String address;
    private String detail_address;
    private boolean insurance;
    private int creator;
    private int updater;
}
