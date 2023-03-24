package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.PatientDTO;
import com.douzone.dzfinal.entity.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
@Mapper
public interface PatientRepository {
    Optional<Patient> findOneByPhone(PatientDTO.PhoneNumbers phoneNumbers);
}
