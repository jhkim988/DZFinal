package com.douzone.dzfinal.dto;

import java.sql.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReceiptDTO {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class ReceptionInfo {
		private int reception_id;
		private int patient_id;
		private String patient_name;
		private boolean treatment;
		private boolean clinic_request;
		private boolean has_prescription;
		private boolean insurance;
	}

}
