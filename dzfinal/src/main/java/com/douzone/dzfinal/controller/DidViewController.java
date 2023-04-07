package com.douzone.dzfinal.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.DidDTO;
import com.douzone.dzfinal.service.DidService;

@RestController
@RequestMapping("/view")
public class DidViewController {
	@Autowired
	DidService didService;
	
	
	
    
	// 자막출력
	@GetMapping("/getDidSubtitle")
	public List<DidDTO.getDidSubtitle> getDidSubtitle() {
		return didService.getDidSubtitle();
	}
	
	// 비디오 하나 찾기
	@GetMapping("/findOneDidVideo")
	public List<DidDTO.findOneDidVideo> findOneDidVideo() {
		return didService.findOneDidVideo();
	}

	
	// 비디오 출력
	@GetMapping("/getDidVideo")
	public ResponseEntity<byte[]> getDidVideo() throws IOException {
		String videoName = didService.getVideoName();
		String videoPath = "/Users/yoonz/Desktop/video/";
	    
		// 동영상 파일을 byte 배열로 읽어옴
	    byte[] videoBytes = getVideoBytes(videoPath, videoName);

	    // HTTP 응답의 헤더를 설정
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("video/mp4")); // 동영상 파일의 MIME 타입
	    headers.setContentLength(videoBytes.length); // 동영상 파일의 크기

	    // HTTP 응답의 바디에 byte 배열을 설정하여 ResponseEntity 객체 생성
	    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(videoBytes, headers, HttpStatus.OK);
	    return responseEntity;
	 }


	
	public static byte[] getVideoBytes(String filePath, String fileName) throws IOException {
        File file = new File(filePath + fileName);
        return Files.readAllBytes(file.toPath());
    }
}