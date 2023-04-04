package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface EmployeeRepository {
    Optional<EmployeeDTO.EmployeeLoginInfo> getEmployee(String user_id);
}
