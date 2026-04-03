package com.sahil.WhatsappChatbotApplication.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WhatsappResponse {

    @JsonProperty("to")
    public String to;

    @JsonProperty("reply")
    public String reply;

    @JsonProperty("status")
    public String status;
}
