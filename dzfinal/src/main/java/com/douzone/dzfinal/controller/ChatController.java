package com.douzone.dzfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/chatlist")
	public List<ChatDTO.ChatRoom> chatRoomList(){
		return chatService.chatRoomList();
	}
	
	@GetMapping("/getchatroommessages")
	public List<ChatDTO.Message> getChatRoomMessages(@RequestParam("chatroom_id") int chatroom_id) {
		return chatService.getChatRoomMessages(chatroom_id);
	}
}
