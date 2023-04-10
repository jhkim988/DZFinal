package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.DidDTO;

@Repository
@Mapper
public interface DidRepository {
	
	// DID(윤지)
	List<DidDTO.getDidVideo> getDidVideo();
	List<DidDTO.getDidSubtitle> getDidSubtitle();
	String getVideoName();
	
	
	// DID-SETTING(정주)
	List<DidDTO.DID_Message> getDidMessage();
	int insertDidMessage(DidDTO.DID_Message message);
	void toggleActive(DidDTO.DID_Message paramData);
	void updateMessage(DidDTO.DID_Message paramData);
	void deleteMessgae(int id);
	void did_Setting(@Param("type") String type, @Param("video_name") String video_name, @Param("video_real_name") String video_real_name, @Param("size") long size);
	List<DidDTO.DID_Video> getVideoList();
}