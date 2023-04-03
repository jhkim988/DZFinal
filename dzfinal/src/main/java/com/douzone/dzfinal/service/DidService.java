package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.DidDTO;
import com.douzone.dzfinal.dto.DidDTO.DID_subtitle;
import com.douzone.dzfinal.repository.DidRepository;

@Service
public class DidService {
	private final DidRepository didRepository;
	
	
	// DID 화면 출력(윤지)
	public List<DidDTO.getDidVideo> getDidVideo() {
		return didRepository.getDidVideo();
	}
	
	public List<DidDTO.getDidSubtitle> getDidSubtitle() {
		return didRepository.getDidSubtitle();
	}
	
	
	
	// DID-SETTING(정주)
	public DidService(DidRepository didRepository) {
		this.didRepository = didRepository;
	}

	public List<DidDTO> getDidMessage() {
		return didRepository.getDidMessage();
	}

	public int insertDidMessage(DidDTO.DID_subtitle message) {
		didRepository.insertDidMessage(message);
		return message.getId();
	}

	public void toggleActive(DidDTO.DID_subtitle paramData) {
		didRepository.toggleActive(paramData);
	}
	
	public void updateMessage(DidDTO.DID_subtitle paramData) {
		didRepository.updateMessage(paramData);
	}
	
	public void did_Setting(String type, String video_name, String video_real_name) {
		didRepository.did_Setting(type, video_name, video_real_name);
	}






}