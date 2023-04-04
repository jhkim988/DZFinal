package com.douzone.dzfinal.dto;

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
	}
	
	@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Message {
        private String state;
    }
}