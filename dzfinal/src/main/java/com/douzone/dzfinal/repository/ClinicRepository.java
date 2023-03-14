package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Patient;

@Repository
@Mapper
public interface ClinicRepository {
	Patient getPatient(int reception_id);
	List<Map<String, String>> getUnderlyingList(int reception_id);
	List<Map<String, String>> getDrug_TakingList(int reception_id);
}