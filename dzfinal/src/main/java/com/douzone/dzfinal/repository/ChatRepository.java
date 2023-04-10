package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.ChatDTO;

@Repository
@Mapper
public interface ChatRepository {
	
	public List<ChatDTO.chatList> chatRoomList(int participants_id);
	
}
