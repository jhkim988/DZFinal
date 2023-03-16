package com.douzone.dzfinal.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Patient;

@Repository
@Mapper
public interface PatientRepository {

	public int insertPatient(Patient patient);
}
