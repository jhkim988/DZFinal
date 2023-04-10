package com.douzone.dzfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/{participants_id}")
	public List<ChatDTO.chatList> chatRoomList(@PathVariable int participants_id){
		return chatService.chatRoomList(participants_id);
	}
}
