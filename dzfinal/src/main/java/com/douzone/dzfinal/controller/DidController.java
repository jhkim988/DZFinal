package com.douzone.dzfinal.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<DidDTO> getDidMessage() {
		return didService.getDidMessage();
	}
	
	@PostMapping("/did_subtitle")
	public int insertDidMessage(@RequestBody DidDTO.DID_subtitle message) {
		return didService.insertDidMessage(message);
	}
	
	@PutMapping("/did_subtitle")
	public boolean toggleActive(@RequestBody DidDTO.DID_subtitle paramData) {
		didService.toggleActive(paramData);
		return true;
	}
	
	@PutMapping("/updatemessage")
	public void updateMessage(@RequestBody DidDTO.DID_subtitle paramData) {
		didService.updateMessage(paramData);
	}
	
	@PostMapping("/did_setting")
	public boolean did_Setting(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) {
		String video_real_name = "upload" + System.currentTimeMillis();
		File saveFile = new File("c:\\didVideo\\" + video_real_name);
		boolean message = false;
		
		try (OutputStream os = new FileOutputStream(saveFile)) {
			os.write(file.getBytes());
			didService.did_Setting(type, file.getOriginalFilename(), video_real_name);
			message = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}
}