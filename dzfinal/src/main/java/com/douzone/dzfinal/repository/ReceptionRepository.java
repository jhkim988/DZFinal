package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Reception;

@Repository
@Mapper
public interface ReceptionRepository {
	
	public List<Reception> receptionList();
	
	public int insertReception(Reception reception);
}
