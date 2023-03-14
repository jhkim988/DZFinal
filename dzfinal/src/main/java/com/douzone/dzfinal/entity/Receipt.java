package com.douzone.dzfinal.entity;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {
	private int receipt_id;
	private int reception_id;
	private double ratio;
	private int total_amount;
	private String card_name;
	private String card_number;
	private String mode;
	private int creator;
	private Timestamp created_at;
}
