package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.EmployeeDTO;
import com.douzone.dzfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/{user_id}")
	public EmployeeDTO.EmployeeLoginInfo getEmployee(@PathVariable("user_id") String user_id) {
		return employeeService.getEmployee(user_id);
	}
}
