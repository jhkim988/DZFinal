package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DidDTO {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class DID_subtitle {
		private int id;
		private String message;
		private boolean active;
	}
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class DID_type {
		private int id;
		private String type;
		private String video_name;
		private String video_real_name;
	}
}
