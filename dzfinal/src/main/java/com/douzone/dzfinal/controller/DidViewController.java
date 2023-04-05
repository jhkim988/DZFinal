package com.douzone.dzfinal.controller;

import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.DidDTO;
import com.douzone.dzfinal.service.DidService;
import com.google.common.net.HttpHeaders;

@RestController
@RequestMapping("/view")
public class DidViewController {
	@Autowired
	DidService didService;
	
	// 비디오 출력
	@GetMapping("/getDidVideo")
	public List<DidDTO.getDidVideo> getDidVideo() {
//		// 동영상 파일을 byte 배열로 읽어옴
//		byte[] videoBytes = getVideoBytes();
//
//		// HTTP 응답의 헤더를 설정
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "video/mp4"); // 동영상 파일의 MIME 타입
//		headers.add("Content-Length", String.valueOf(videoBytes.length)); // 동영상 파일의 크기
//
//		// HTTP 응답의 바디에 byte 배열을 설정
//		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(videoBytes, headers, HttpStatus.OK);
//
//		// 클라이언트로 HTTP 응답 전송
//		OutputStream outputStream = response.getOutputStream();
//		outputStream.write(videoBytes);
//		outputStream.flush();
		
		return didService.getDidVideo();
	}
	// 자막출력
	@GetMapping("/getDidSubtitle")
	public List<DidDTO.getDidSubtitle> getDidSubtitle() {
		return didService.getDidSubtitle();
	}
	
}