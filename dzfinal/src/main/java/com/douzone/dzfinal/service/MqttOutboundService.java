package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.WaitingDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttOutboundService {
    @Autowired
    private MqttOutboundGateway gateway;
    @Autowired
    private ObjectMapper mapper;

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
}
