package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Chat;

@Repository
@Mapper
public interface ChatRepository {
	public List<Chat> chatRoomList();
}
