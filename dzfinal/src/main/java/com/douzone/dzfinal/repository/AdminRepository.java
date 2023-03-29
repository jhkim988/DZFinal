package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.AdminDTO;
import com.douzone.dzfinal.dto.AdminDTO.Employee;
import com.douzone.dzfinal.dto.AdminDTO.EmployeeInfo;

@Repository
@Mapper
public interface AdminRepository {
	void register(AdminDTO.EmployeeInfo employee);
	List<Employee> getEmployee();
	void updateEmployee(EmployeeInfo employee);
	void deleteEmployee(int employ_id);
}
