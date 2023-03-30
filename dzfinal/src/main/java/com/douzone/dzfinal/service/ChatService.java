package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Chat;
import com.douzone.dzfinal.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository chatRepository;
	
	public List<Chat> chatRoomList(){
		return chatRepository.chatRoomList(); 
	}
}

