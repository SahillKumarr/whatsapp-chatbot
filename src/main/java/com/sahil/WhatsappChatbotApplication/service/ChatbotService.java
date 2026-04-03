package com.sahil.WhatsappChatbotApplication.service;


import com.sahil.WhatsappChatbotApplication.model.WhatsappMessage;
import com.sahil.WhatsappChatbotApplication.model.WhatsappResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatbotService {

    private static final Logger logger= LoggerFactory.getLogger(ChatbotService.class);

    private static final Map<String, String> REPLY_MAP = new HashMap<>();

    static {
        REPLY_MAP.put("hi",       "Hello! How can I help you today?");
        REPLY_MAP.put("hello",    "Hello! How can I help you today?");
        REPLY_MAP.put("bye",      "Goodbye! Have a great day!");
        REPLY_MAP.put("goodbye",  "Goodbye! Have a great day!");
        REPLY_MAP.put("help",     "Type 'Hi' to start or 'Bye' to end the chat.");
        REPLY_MAP.put("thanks",   "You're welcome!");
        REPLY_MAP.put("thank you","You're welcome!");
    }

    public WhatsappResponse processMessage(WhatsappMessage incomingMessage) {
        logger.info("Incoming Message From {}: {}", incomingMessage.getFrom(),incomingMessage.getMessage());

        String reply = generateReply(incomingMessage.getMessage());
        logger.info(" Replying to {} : {}", incomingMessage.getFrom(), reply);

        return new WhatsappResponse(incomingMessage.getFrom(),reply,"Sent");

    }

    private String generateReply(String message) {
        if (message == null || message.isBlank()) {
            return "Please send a message so I can help you!";
        }

        String lower = message.trim().toLowerCase();

        if (REPLY_MAP.containsKey(lower)) {
            return REPLY_MAP.get(lower);
        }

        for (Map.Entry<String, String> entry : REPLY_MAP.entrySet()) {
            if (lower.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "I didn't understand that, Type 'help' for options.";
    }
}
