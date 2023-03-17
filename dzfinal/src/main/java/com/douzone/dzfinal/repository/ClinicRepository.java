package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Optional;

import com.douzone.dzfinal.dto.PatientDrugJoin;
import com.douzone.dzfinal.dto.PatientUnderlyingJoin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.entity.Disease;
import com.douzone.dzfinal.entity.Drug;

@Repository
@Mapper
public interface ClinicRepository {
	Optional<ClinicResponse.Clinic> getClinic(int reception_id);
	List<PatientDrugJoin> getDrugList(@Param("patient_id") int patient_id);
	List<PatientUnderlyingJoin> getDiseaseList(@Param("patient_id") int patient_id);
}