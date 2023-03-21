package com.douzone.dzfinal.repository;


import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Patient;

@Repository
@Mapper
public interface PatientRepository {

	public int insertPatient(Patient patient);
	
	public int getPatientId(Patient patient);
	
	public List<Patient> searchPatient(String patient_name);
	
	public Optional<Patient> searchPatientInfo(int patient_id);
	
//	public Optional<Patient> searchPatient(String patient_name);
//	public List<Patient> searchPatient(Map<String, String> param);
	/* Optional<Patient> getOnePatientId(int patient_id); */
}
