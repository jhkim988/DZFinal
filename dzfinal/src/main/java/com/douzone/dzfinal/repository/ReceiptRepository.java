package com.douzone.dzfinal.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Receipt;

@Repository
@Mapper
public interface ReceiptRepository {
	Receipt test();
<<<<<<< HEAD
	void test1();
=======
//	void test1();
>>>>>>> receipt
}