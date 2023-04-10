package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class EmployeeDTO {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class EmployeeLoginInfo {
        private long employ_id;
        private String employee_name;
        private String real_image;
//        private List<String> authority;
        private String authority;
    }
    
    @NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Builder
	public static class EmployeeInfo {
		private int employ_id;
		private String user_id;
		private String pwd;
		private String employee_name;
		private String birth;
		private String role;
		private String image_name;
		private String real_image;
		private String employee_email;
	}
}
