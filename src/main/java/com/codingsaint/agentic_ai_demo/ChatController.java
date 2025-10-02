package com.codingsaint.agentic_ai_demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.HashMap;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClientService chatClientService;

    @Autowired
    public ChatController(ChatClientService chatClientService) {
        this.chatClientService = chatClientService;
    }

    @PostMapping
    public Flux<String> chat(@RequestBody HashMap<String,String> message) {
        return chatClientService.sendMessage(message.get("message"));

    } @PostMapping("/v2")
    public String chatV2(@RequestBody HashMap<String,String> message) {

        return chatClientService.chat(message.get("message"));

    }
}
