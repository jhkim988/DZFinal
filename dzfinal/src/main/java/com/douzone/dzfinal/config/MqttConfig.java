package com.douzone.dzfinal.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class MqttConfig {
    @Bean
    public DefaultMqttPahoClientFactory defaultMqttPahoClientFactory() {
        DefaultMqttPahoClientFactory clientFactory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{"tcp://192.168.0.132:1883"});
        clientFactory.setConnectionOptions(options);
        return clientFactory;
    }
    @Bean
    public MessageProducer mqttInboundAdapter() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("tcp://192.168.0.132:1883","springBoot1","waiting", "chat");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInboundChannel());
        return adapter;
    }

    @Bean("mqttInboundChannel")
    public MessageChannel mqttInboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInboundChannel")
    public MessageHandler inboundMessageHandler() {
        return message -> {
            System.out.println(message.getHeaders());
            System.out.println(message.getPayload());
        };
    }

    @Bean("mqttOutboundChannel")
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound(DefaultMqttPahoClientFactory clientFactory) {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("springBoot2", clientFactory);
        messageHandler.setAsync(true);
        messageHandler.setDefaultQos(1);
        return messageHandler;
    }
}
