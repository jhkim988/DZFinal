package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.AdminDTO;
import com.douzone.dzfinal.dto.AdminDTO.Employee;
import com.douzone.dzfinal.dto.AdminDTO.EmployeeInfo;
import com.douzone.dzfinal.repository.AdminRepository;

@Service
public class AdminService {
	private final AdminRepository adminRepository;
	
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public void register(AdminDTO.EmployeeInfo employee) {
		adminRepository.register(employee);
	}

	public List<Employee> getEmployee() {
		return adminRepository.getEmployee();
	}

	public void updateEmployee(EmployeeInfo employee) {
		adminRepository.updateEmployee(employee);
	}

	public void deleteEmployee(int employ_id) {
		adminRepository.deleteEmployee(employ_id);
	}
}
