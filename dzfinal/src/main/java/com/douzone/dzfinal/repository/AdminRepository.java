package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Optional;

import com.douzone.dzfinal.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.AdminDTO;
import com.douzone.dzfinal.dto.AdminDTO.EmployeeInfo;

@Repository
@Mapper
public interface AdminRepository {
	void register(AdminDTO.EmployeeInfo employee);
	List<AdminDTO.Employee> getEmployee();
	Optional<Employee> findOneById(int employ_id);
	void updateEmployee(EmployeeInfo employee);
	void deleteEmployee(int employ_id);
}
