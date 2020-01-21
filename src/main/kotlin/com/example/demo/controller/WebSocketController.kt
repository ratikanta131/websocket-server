package com.example.demo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.handler.annotation.MessageMapping
import java.text.SimpleDateFormat
import java.util.Date

@Controller
class WebSocketController {
	
	@Autowired
	lateinit var template: SimpMessagingTemplate
	
	@MessageMapping("send/msg/tocrime")
	fun onReceiveMessage(message: String){
		template.convertAndSend("/topic/crime", SimpleDateFormat("HH:mm:ss").format(Date()) + "-"+ message)
	}
	
	@MessageMapping("send/msg/toadmin")
	fun onReceiveMessageToAdmin(message: String){
		template.convertAndSend("/queue/toadmin", SimpleDateFormat("HH:mm:ss").format(Date()) + "-rk-"+ message)
	}
	
	@MessageMapping("send/msg/toratikanta")
	fun onReceiveMessageToratikanta(message: String){
		template.convertAndSend("/queue/toratikanta", SimpleDateFormat("HH:mm:ss").format(Date()) + "-rk-"+ message)
	}
	
}