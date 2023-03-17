package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.ClinicResponse;

@Repository
@Mapper
public interface ClinicRepository {
	Optional<ClinicResponse.Clinic> getClinic(int reception_id);
	List<ClinicResponse.DrugTaking> getDrugList(@Param("patient_id") int patient_id);
	List<ClinicResponse.Underlying> getDiseaseList(@Param("patient_id") int patient_id);
}