package com.douzone.dzfinal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ChatDTO {	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class ChatRoom {
		private int chatroom_id;
		private String chatroom_name;
		private List<String> employee_names;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Message {
	    private String mode;
	    private int chatroom_id;
	    private int from;
	    private String employee_name;
	    private String thumbnail_image;
	    private String message;
	    private String created_at;
	}
}