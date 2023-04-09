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
	
	public List<ChatDTO.ChatRoom> chatRoomList(int participants_id){
		return chatRepository.chatRoomList(participants_id); 
	}
	
	public List<ChatDTO.Message> getChatRoomMessages(int chatroom_id, int page) {
		return chatRepository.getChatRoomMessages(chatroom_id, page);
	}

	public List<ChatDTO.MessageCount> getMessageCount(int participants_id) {
	    return chatRepository.getMessageCount(participants_id);
	}
	
	public void updateLastReadTime(ChatDTO.ChatRoomStatus status) {
		chatRepository.updateLastReadTime(status);
	}

	public void is_Close(ChatDTO.ChatRoomStatus status) {
		chatRepository.is_Close(status);
	}
}

