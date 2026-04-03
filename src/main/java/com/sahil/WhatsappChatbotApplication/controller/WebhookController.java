package com.sahil.WhatsappChatbotApplication.controller;


import com.sahil.WhatsappChatbotApplication.model.WhatsappMessage;
import com.sahil.WhatsappChatbotApplication.model.WhatsappResponse;
import com.sahil.WhatsappChatbotApplication.service.ChatbotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger logger= LoggerFactory.getLogger(WebhookController.class);

    private ChatbotService service;

    WebhookController(ChatbotService service){
        this.service= service;
    }

    @PostMapping
    public ResponseEntity<WhatsappResponse> receiveMessage(@RequestBody WhatsappMessage incomingMessage){
        logger.info("Webhook has been triggered from: {}", incomingMessage.getFrom());

        if (incomingMessage.getFrom() == null || incomingMessage.getMessage() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        WhatsappResponse response = service.processMessage(incomingMessage);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String,String>> healthCheck(){
        Map<String,String> status = new HashMap<>();
        status.put("message", "WhatsApp Chatbot is up!");
        return ResponseEntity.ok(status);
    }






}
