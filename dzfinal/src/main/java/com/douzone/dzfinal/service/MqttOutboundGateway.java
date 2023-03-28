package com.douzone.dzfinal.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttOutboundGateway {
    @Gateway(requestChannel = "mqttOutboundChannel")
    void sendToMqtt(String waitingDTO, @Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos);
}