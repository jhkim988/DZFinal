package com.douzone.dzfinal.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.DidDTO;
import com.douzone.dzfinal.dto.DidDTO.DID_subtitle;

@Repository
@Mapper
public interface DidRepository {
	List<DidDTO> getDidMessage();
	int insertDidMessage(DidDTO.DID_subtitle message);
	void did_Setting(@Param("type") String type, @Param("video_name") String video_name, @Param("video_real_name") String video_real_name);
	void toggleActive(DidDTO.DID_subtitle paramData);
	void updateMessage(DidDTO.DID_subtitle paramData);
}