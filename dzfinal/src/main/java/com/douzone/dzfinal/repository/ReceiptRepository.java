package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Receipt;

@Repository
@Mapper
public interface ReceiptRepository {
	
	Receipt test();
	
	// 수납
	public Receipt insertReceipt(Receipt receipt);
	
	public List<Receipt> receiptList();

	
	
}