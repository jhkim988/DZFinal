package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.ReceiptResponse.Clinic;

@Repository
@Mapper
public interface ClinicRepository {
	List<Clinic> findAll();

	com.douzone.dzfinal.entity.Clinic findById(int reception_id);
}