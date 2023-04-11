package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.DidDTO;
import com.douzone.dzfinal.repository.DidRepository;

@Service
public class DidService {
	private final DidRepository didRepository;
	
	public DidService(DidRepository didRepository) {
		this.didRepository = didRepository;
	}
	
	// DID 화면 출력(윤지)
	public List<DidDTO.getDidVideo> getDidVideo() {
		return didRepository.getDidVideo();
	}
	
	public List<DidDTO.getDidSubtitle> getDidSubtitle() {
		return didRepository.getDidSubtitle();
	}
	
	public String getVideoName() {
		return didRepository.getVideoName();
	}
	
	
	// DID-SETTING(정주)
	public List<DidDTO.DID_Message> getDidMessage() {
		return didRepository.getDidMessage();
	}

	public int insertDidMessage(DidDTO.DID_Message message) {
		didRepository.insertDidMessage(message);
		return message.getId();
	}

	public void toggleActive(DidDTO.DID_Message paramData) {
		didRepository.toggleActive(paramData);
	}
	
	public void updateMessage(DidDTO.DID_Message paramData) {
		didRepository.updateMessage(paramData);
	}

	public void deleteMessgae(int id) {
		didRepository.deleteMessgae(id);
	}

	public List<DidDTO.DID_Video> getVideoList() {
		return didRepository.getVideoList();
	}

	public int insertVideo(DidDTO.DID_Video video) {
		didRepository.insertVideo(video);
		return video.getId();
	}

	public void toggleVideo(DidDTO.DID_Video paramData) {
		didRepository.toggleVideo(paramData);
	}

	public void deleteVideo(int id) {
		didRepository.deleteVideo(id);
	}
}