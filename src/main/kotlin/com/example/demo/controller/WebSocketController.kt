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
	
	@MessageMapping("send/message")
	fun onReceiveMessage(message: String){
		template.convertAndSend("/chat", SimpleDateFormat("HH:mm:ss").format(Date()) + "-"+ message)
	}
	
}