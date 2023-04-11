package com.douzone.dzfinal.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.dzfinal.dto.DidDTO;
import com.douzone.dzfinal.service.DidService;

@RestController
@RequestMapping("/did")
public class DidController {
	@Autowired
	DidService didService;
	
	@GetMapping("/did_subtitle")
	public List<DidDTO.DID_Message> getDidMessage() {
		return didService.getDidMessage();
	}
	
	@PostMapping("/did_subtitle")
	public int insertDidMessage(@RequestBody DidDTO.DID_Message message) {
		return didService.insertDidMessage(message);
	}
	
	@PutMapping("/did_subtitle")
	public boolean toggleActive(@RequestBody DidDTO.DID_Message paramData) {
		try {
			didService.toggleActive(paramData);
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("/updatemessage")
	public void updateMessage(@RequestBody DidDTO.DID_Message paramData) {
		didService.updateMessage(paramData);
	}
	
	@DeleteMapping("/did_subtitle")
	public void deleteMessage(@RequestParam("id") int id) {
		didService.deleteMessgae(id);
	}
	
	@GetMapping("/did_video")
	public List<DidDTO.DID_Video> getVideoList() {
		return didService.getVideoList();
	}
	
	@PostMapping("/did_video")
	public int insertVideo(@RequestParam("file") MultipartFile file) {
		DidDTO.DID_Video video = DidDTO.DID_Video.builder()
				.video_real_name("upload" + System.currentTimeMillis())
				.video_name(file.getOriginalFilename())
				.size(file.getSize())
				.active(false).build();
		File saveFile = new File("C:\\upload\\didVideo\\" + video.getVideo_real_name());
		
		try (OutputStream os = new FileOutputStream(saveFile)) {
			os.write(file.getBytes());
			return didService.insertVideo(video);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@PutMapping("/did_video")
	public boolean toggleVideo(@RequestBody DidDTO.DID_Video paramData) {
		try {
			didService.toggleVideo(paramData);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@DeleteMapping("/did_video")
	public void deleteVideo(@RequestParam("id") int id) {
		didService.deleteVideo(id);
	}
}