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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/chatlist")
	public List<ChatDTO.ChatRoom> chatRoomList(@RequestParam("participants_id") int participants_id){
		return chatService.chatRoomList(participants_id);
	}
	
	@GetMapping("/getthumbnaillist")
	public List<ChatDTO.Thumbnail> getThumbnailList() {
		return chatService.getThumbnail();
	}
	
	@GetMapping("/getchatroommessages")
	public List<ChatDTO.Message> getChatRoomMessages(@RequestParam("chatroom_id") int chatroom_id, @RequestParam("page") int page) {
		return chatService.getChatRoomMessages(chatroom_id, page);
	}
	
	@GetMapping("/getthumbnail")
	public ResponseEntity<byte[]> getThumbnail(@RequestParam("thumbnail_image") String thumbnail_image) {
		File file = new File("c:\\upload\\thumbnail\\" + thumbnail_image);
		
		try {
	        byte[] imageBytes = Files.readAllBytes(file.toPath());
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_JPEG);
	        return new ResponseEntity<byte[]>(imageBytes, headers, HttpStatus.OK);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new ResponseEntity<byte[]>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("getmessagecount")
	public List<ChatDTO.MessageCount> getMessageCount(@RequestParam("participants_id") int participants_id) {
		return chatService.getMessageCount(participants_id);
	}
	
	@PutMapping("/lastreadtime")
	public void updateLastReadTime(@RequestBody ChatDTO.ChatRoomStatus status) {
		chatService.updateLastReadTime(status);
	}
	
	@PutMapping("/exit")
	public void is_Close(@RequestBody ChatDTO.ChatRoomStatus status) {
		chatService.is_Close(status);
	}
}
