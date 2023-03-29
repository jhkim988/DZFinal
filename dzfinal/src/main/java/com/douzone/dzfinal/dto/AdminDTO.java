package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AdminDTO {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
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
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class Employee {
		private int employ_id;
		private String user_id;
		private String employee_name;
		private String birth;
		private String role;
		private String real_image;
		private String employee_email;
	}
}