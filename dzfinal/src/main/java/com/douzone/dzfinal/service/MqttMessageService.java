package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.dto.WaitingDTO;
import com.douzone.dzfinal.repository.ChatRepository;
import com.douzone.dzfinal.repository.ReceptionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void sendToWaiting(String method, int reception_id, String state) {
        WaitingDTO waitingDTO = WaitingDTO.builder()
                .method(method)
                .data(WaitingDTO.WaitingData.builder()
                        .reception_id(reception_id)
                        .state(state)
                        .build())
                .build();
        try {
            gateway.sendToMqtt(mapper.writeValueAsString(waitingDTO), "waiting", 1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateReception(String message) {
        System.out.println("Update Reception");
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
    
    public void receiveChat(String message) {
    	System.out.println(message);
    	try {
        	ChatDTO.Message chatMessage = mapper.readValue(message, ChatDTO.Message.class);
        	
        	chatRepository.insert(chatMessage);
    	} catch (JsonProcessingException e) {
    		
    	}
    }
}
