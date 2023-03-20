package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Patient;

@Repository
@Mapper
public interface PatientRepository {
	List<Patient> findAll();

	Patient findById(int reception_id);
}