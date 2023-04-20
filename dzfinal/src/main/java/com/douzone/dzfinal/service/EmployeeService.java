package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.EmployeeDTO;
import com.douzone.dzfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PreAuthorize("#user_id == authentication.principal.user_name")
    public EmployeeDTO.EmployeeLoginInfo getEmployee(String user_id) {
        return employeeRepository.getEmployee(user_id).orElseThrow(IllegalArgumentException::new);
    }

    public List<EmployeeDTO.Doctor> getDoctorList() {
    	return employeeRepository.getDoctorList();
    }
    public EmployeeDTO.EmployeeInfo selectEmployeeInfo(String user_id) {
        return employeeRepository.selectEmployeeInfo(user_id).orElseThrow(IllegalArgumentException::new);
    }
}
