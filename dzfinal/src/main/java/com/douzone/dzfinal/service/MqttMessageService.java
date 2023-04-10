package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.dto.WaitingDTO;
import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.repository.ChatRepository;
import com.douzone.dzfinal.repository.ReceptionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

@Service
public class MqttMessageService {
    @Autowired
    private MqttOutboundGateway gateway;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private ChatRepository chatRepository;

    public void sendToWaiting(WaitingDTO waitingDTO) {
        try {
            gateway.sendToWaiting(mapper.writeValueAsString(waitingDTO), "waiting", 1);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Need WaitingDTO");
        }
    }

    public void updateWaitingState(int reception_id, String state) {
        WaitingDTO waitingDTO = WaitingDTO.builder().method("PUT").data(WaitingDTO.WaitingData.builder()
                .reception_id(reception_id)
                .state(state)
                .build())
                .build();
        sendToWaiting(waitingDTO);
    }
    public void updateReception(String message) {
        try {
            WaitingDTO dto = mapper.readValue(message, WaitingDTO.class);
            WaitingDTO.WaitingData data = dto.getData();
            if (dto.getMethod().equals("PUT")) {
                receptionRepository.update(data);
            }
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Need WaitingDTO");
        }
    }
    
    public void receiveChat(String message, MessageHeaders messageHeaders) {
    	System.out.println(message);
    	
    	try {
        	ChatDTO.Message chatMessage = mapper.readValue(message, ChatDTO.Message.class);
        	chatRepository.insert(chatMessage);
        	
        	String topic = messageHeaders.get("mqtt_receivedTopic").toString();
        	int chatroom_id = Integer.parseInt(topic.substring(topic.indexOf("chat/") + "chat/".length())); // chatroom_id 값 얻기
        	int participants_id = chatMessage.getFrom(); // 보낸사람
        	
        	List<Integer> notificationTargetIds = chatRepository.getNotificationTargetIds(chatroom_id, participants_id);
        	for (Integer targetId : notificationTargetIds) {
        		List<ChatDTO.MessageCount> chatDTO = chatRepository.getMessageCount(targetId);
        		gateway.sendToChat("", "notification/"+targetId, 1);
        	}
    	} catch (JsonProcessingException e) {
    		throw new IllegalArgumentException();
    	}
//    	try {
//        	ChatDTO.Message chatMessage = mapper.readValue(message, ChatDTO.Message.class);
//        	chatRepository.insert(chatMessage);
//        	
//        	String topic = messageHeaders.get("mqtt_receivedTopic").toString();
//        	int chatroom_id = Integer.parseInt(topic.substring(topic.indexOf("chat/") + "chat/".length())); // chatroom_id 값 얻기
//        	int participants_id = chatMessage.getFrom(); // 보낸사람
//        	
//        	List<Integer> notificationTargetIds = chatRepository.getNotificationTargetIds(chatroom_id, participants_id);
//        	for (Integer targetId : notificationTargetIds) {
//        		List<ChatDTO.MessageCount> chatDTO = chatRepository.getMessageCount(targetId);
//        		Gson gson = new Gson();
//        		String json = gson.toJson(chatDTO);
//        		gateway.sendToChat(json, "notification/"+targetId, 1);
//        	}
//    	} catch (JsonProcessingException e) {
//    		throw new IllegalArgumentException();
//    	}
    }
}
