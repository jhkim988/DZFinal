package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.WaitingDTO;
import com.douzone.dzfinal.service.MqttOutboundGateway;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@Autowired
	private MqttOutboundGateway gateway;
	@GetMapping("/test")
	public void test() throws JsonProcessingException {
		WaitingDTO waitingDTO = WaitingDTO.builder()
				.method("PUT")
				.data(WaitingDTO.WaitingData.builder()
						.reception_id(7)
						.state("수납완료")
						.build())
				.build();
		ObjectMapper mapper = new ObjectMapper();
		gateway.sendToMqtt(mapper.writeValueAsString(waitingDTO), "waiting", 1);
	}
}
