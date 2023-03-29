package com.douzone.dzfinal.repository;
	
import com.douzone.dzfinal.dto.PatientDTO;
import com.douzone.dzfinal.entity.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;
@Mapper
public interface PatientRepository {
	
    Optional<Patient> findOneByPhone(PatientDTO.PhoneNumbers phoneNumbers);
    
	public int insertPatient(Patient patient);
	
	public int getPatientId(Patient patient);
	
	public List<Patient> searchPatient(String patient_name);
	
	public Optional<Patient> searchPatientInfo(int patient_id);
}
