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
@RequestMapping("/view")
public class DidViewController {
	@Autowired
	DidService didService;
	
	// 비디오 출력
	@GetMapping("/getDidVideo")
	public List<DidDTO.getDidVideo> getDidVideo() {
		return didService.getDidVideo();
	}
	// 자막출력
	@GetMapping("/getDidSubtitle")
	public List<DidDTO.getDidSubtitle> getDidSubtitle() {
		return didService.getDidSubtitle();
	}
	
}