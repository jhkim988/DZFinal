package com.douzone.dzfinal.dto;

import lombok.Data;

@Data
public class PatientDrugJoin {
    private String drug_id;
    private String drug_code;
    private String drug_name;
    private int patient_id;
}
