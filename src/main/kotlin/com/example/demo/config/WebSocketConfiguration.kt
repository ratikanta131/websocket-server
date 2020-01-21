package com.example.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.messaging.simp.config.MessageBrokerRegistry

@Configuration
@EnableWebSocketMessageBroker
open class WebSocketConfiguration : WebSocketMessageBrokerConfigurer{
	
	override fun registerStompEndpoints(registry : StompEndpointRegistry){
		
		registry.addEndpoint("/socket")
			.setAllowedOrigins("*")
			.withSockJS()
	}
	
	override fun configureMessageBroker(registry: MessageBrokerRegistry){
		
		registry.setApplicationDestinationPrefixes("/app")
				.enableStompBrokerRelay("/topic", "/queue")
				
				
			.setRelayHost("localhost")
			 .setRelayPort(61613)
			 .setClientLogin("guest")
			 .setClientPasscode("guest")
			 .setSystemLogin("guest")
			 .setSystemPasscode("guest")
		
	}
	
	
}