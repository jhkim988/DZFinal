package com.douzone.dzfinal.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Clinic;

@Repository
@Mapper
public interface ClinicRepository {
	Clinic test();
	void test1();
}