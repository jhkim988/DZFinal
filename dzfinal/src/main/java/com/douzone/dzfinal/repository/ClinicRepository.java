package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.entity.Disease;
import com.douzone.dzfinal.entity.Drug;

@Repository
@Mapper
public interface ClinicRepository {
	@Results({
		@Result(property = "reception_id", column = "reception_id"),
		@Result(property = "patient_id", column = "patient_id"),
		@Result(property = "patient_name", column = "patient_name"),
		@Result(property = "front_registration_number", column = "front_registration_number"),
		@Result(property = "back_registration_number", column = "back_registration_number"),
		@Result(property = "systolic", column = "systolic"),
		@Result(property = "diastolic", column = "diastolic"),
		@Result(property = "blood_sugar", column = "blood_sugar"),
		@Result(property = "height", column = "height"),
		@Result(property = "weight", column = "weight"),
		@Result(property = "bmi", column = "bmi"),
		@Result(property = "drugList",
				column = "d.drug_code",
				many = @Many(select="com.douzone.dzfinal.repository.ClinicRepository.getDrug_TakingList")),
		@Result(property = "diseaseList",
				column = "d.disease_code",
				many = @Many(select="com.douzone.dzfinal.repository.ClinicRepository.getUnderlyingList")),
	})
	Optional<ClinicResponse.Clinic> getClinic(int reception_id);
	
	List<Drug> getDrug_TakingList(int reception_id);
	List<Disease> getUnderlyingList(int reception_id);
}