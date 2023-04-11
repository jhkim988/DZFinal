package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DidDTO {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class DID_Message {
		private int id;
		private String message;
		private boolean active;
	}
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Builder
	public static class DID_Video {
		private int id;
		private String video_name;
		private String video_real_name;
		private long size;
		private boolean active;
	}
	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class getDidVideo {
		private int id;
		private String type;
		private String video_name;
		private String video_real_name;
		private long size;
	}
	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class getDidSubtitle {
		private int id;
		private String message;
		private boolean active;
	}
}
