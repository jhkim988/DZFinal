package com.douzone.dzfinal.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "waitingOutboundChannel")
public interface MqttOutboundGateway {
    @Gateway(requestChannel = "waitingOutboundChannel")
    void sendToWaiting(String waitingDTO, @Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos);

    @Gateway(requestChannel = "chatOutboundChannel")
    void sendToChat(String chatDTO, @Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos);
}