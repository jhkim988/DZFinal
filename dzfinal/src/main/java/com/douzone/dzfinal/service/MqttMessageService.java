package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.WaitingDTO;
import com.douzone.dzfinal.entity.Reception;
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

    public void sendToWaiting(WaitingDTO waitingDTO) {
        try {
            gateway.sendToMqtt(mapper.writeValueAsString(waitingDTO), "waiting", 1);
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
    
    public void receiveChat(String message) {
    	System.out.println(message);
    	try {
        	mapper.readValue(message, Object.class);
    	} catch (JsonProcessingException e) {
    		throw new RuntimeException(e);
    	}
    }
}
