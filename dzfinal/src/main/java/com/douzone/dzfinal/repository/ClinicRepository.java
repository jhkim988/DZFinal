package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.ReceiptResponse.Clinic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClinicRepository {
	List<Clinic> findAll();

	com.douzone.dzfinal.entity.Clinic findById(int reception_id);
}