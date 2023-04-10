package com.douzone.dzfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ChatDTO {
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class chatList{
		private String chatroom_name; 
		private int chatroom_id;
		private int chatroom_participants_id;
		private int participants_id;		
		private String employee_name;
	}
}
