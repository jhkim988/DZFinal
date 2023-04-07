package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.ChatDTO;

@Repository
@Mapper
public interface ChatRepository {
	List<ChatDTO.ChatRoom> chatRoomList(int participants_id);
	void insert(ChatDTO.Message chatMessage);
	List<ChatDTO.Message> getChatRoomMessages(int chatroom_id);
}
