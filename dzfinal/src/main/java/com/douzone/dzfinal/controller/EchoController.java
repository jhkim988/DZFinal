package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.config.MqttOutboundGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@Autowired
	private MqttOutboundGateway gateway;
	@GetMapping("/test")
	public void test() {
		System.out.println("TEST Controller: " + "{\"method\":\"PUT\",\"data\":{\"reception_id\":\"7\",\"state\":\"수납완료\"}}");
		gateway.sendToMqtt("{\"method\":\"PUT\",\"data\":{\"reception_id\":\"7\",\"state\":\"수납완료\"}}", "waiting", 1);
	}
}
