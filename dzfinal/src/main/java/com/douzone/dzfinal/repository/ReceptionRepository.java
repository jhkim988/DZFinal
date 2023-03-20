package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.ReceiptResponse;
import com.douzone.dzfinal.entity.Reception;

@Repository
@Mapper
public interface ReceptionRepository {
	List<Reception> findAll();
}