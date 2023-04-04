package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EmployeeDTO {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class EmployeeLoginInfo {
        private long employ_id;
        private String employee_name;
        private String real_image;
        private String role;
    }
}
