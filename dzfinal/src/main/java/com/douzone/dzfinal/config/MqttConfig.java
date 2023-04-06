package com.douzone.dzfinal.config;

import com.douzone.dzfinal.service.MqttMessageService;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
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

    private String mqttURL = "tcp://192.168.0.132:1883";
//    private String mqttURL = "tcp://127.0.0.1:1883";

    @Autowired
    private MqttMessageService mqttMessageService;

    @Bean
    public DefaultMqttPahoClientFactory defaultMqttPahoClientFactory() {
        DefaultMqttPahoClientFactory clientFactory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{mqttURL});
        clientFactory.setConnectionOptions(options);
        return clientFactory;
    }
    @Bean
    public MessageProducer waitingInboundAdapter() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(mqttURL,"springBoot#Waiting_inbound","waiting");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(waitingInboundChannel());
        return adapter;
    }

    @Bean
    public MessageChannel waitingInboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "waitingInboundChannel")
    public MessageHandler inboundMessageHandler() {
        return message -> {
            mqttMessageService.updateReception((String) message.getPayload());
        };
    }

    @Bean("mqttOutboundChannel")
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound(DefaultMqttPahoClientFactory clientFactory) {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("springBoot#Waiting_outbound", clientFactory);
        messageHandler.setAsync(true);
        messageHandler.setDefaultQos(1);
        return messageHandler;
    }
    
    // 채팅
    @Bean
   	public MessageProducer chatInboundAdapter() {
           MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(mqttURL,"springBoot#Chating_inbound","chat");
           adapter.setCompletionTimeout(5000);
           adapter.setConverter(new DefaultPahoMessageConverter());
           adapter.setQos(1);
           adapter.setOutputChannel(chatInboundChannel());
           return adapter;
       }

   @Bean
   public MessageChannel chatInboundChannel() {
       return new DirectChannel();
   }

   @Bean
   @ServiceActivator(inputChannel = "chatInboundChannel")
   public MessageHandler chatInboundMessageHandler() {
       return message -> {
           mqttMessageService.receiveChat((String) message.getPayload());
       };
   }
}
