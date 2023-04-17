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
		private List<String> thumbnail_images;
	}
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class Thumbnail {
		private int employ_id;
		private String thumbnail_image;
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
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ChatRoomStatus {
		private int participants_id;
		private int chatroom_id;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MessageCount {
		private int chatroom_id;
		private int message_count;
	}
}