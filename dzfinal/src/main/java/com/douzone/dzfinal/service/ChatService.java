package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository chatRepository;
	
	public List<ChatDTO.ChatRoom> chatRoomList(){
		return chatRepository.chatRoomList(); 
	}
	
	public List<ChatDTO.Message> getChatRoomMessages(int chatroom_id) {
		return chatRepository.getChatRoomMessages(chatroom_id);
	}
}

