package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private int employ_id;
    private String user_id;
    private String employee_name;
    private String birth;
    private String role;
    private String real_image;
    private String thumbnail_image;
    private String employee_email;
    private boolean is_deleted;
}
