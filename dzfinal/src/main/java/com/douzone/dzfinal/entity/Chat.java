package com.douzone.dzfinal.entity;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat {
	private int chat_id;
	private int chatroom_id;
	private String message;
	private Time created_at;
	private int from;
	private String chatroom_name;
	private int chatroom_participants_id;
	private int participants_id;
}
