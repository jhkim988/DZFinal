package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.EmployeeDTO;
import com.douzone.dzfinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PreAuthorize("#user_id == authentication.principal.user_name")
    public EmployeeDTO.EmployeeLoginInfo getEmployee(String user_id) {
        return employeeRepository.getEmployee(user_id).orElseThrow(IllegalArgumentException::new);
    }
}
