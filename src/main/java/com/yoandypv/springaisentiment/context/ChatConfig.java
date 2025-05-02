package com.yoandypv.springaisentiment.context;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChatConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder clientBuilder) {
        return clientBuilder
                .build();
    }
}