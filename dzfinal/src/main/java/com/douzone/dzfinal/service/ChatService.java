package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.entity.Chat;
import com.douzone.dzfinal.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	public List<ChatDTO.chatList> chatRoomList(int participants_id){
		return chatRepository.chatRoomList(participants_id); 
	}
}

