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
	List<DidDTO.findOneDidVideo> findOneDidVideo();
	List<DidDTO.getDidVideo> getDidVideo();
	List<DidDTO.getDidSubtitle> getDidSubtitle();
	String getVideoName();
	
	
	// DID-SETTING(정주)
	List<DidDTO.DID_Message> getDidMessage();
	int insertDidMessage(DidDTO.DID_Message message);
	void toggleActive(DidDTO.DID_Message paramData);
	void updateMessage(DidDTO.DID_Message paramData);
	void deleteMessgae(int id);
	List<DidDTO.DID_Video> getVideoList();
	int insertVideo(DidDTO.DID_Video video);
	void toggleVideo(DidDTO.DID_Video paramData);
	void deleteVideo(int id);
}