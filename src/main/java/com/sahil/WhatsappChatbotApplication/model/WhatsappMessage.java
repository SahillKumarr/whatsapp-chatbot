package com.sahil.WhatsappChatbotApplication.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WhatsappMessage {

    @JsonProperty("from")
    public String from;

    @JsonProperty("message")
    public String message;
}
