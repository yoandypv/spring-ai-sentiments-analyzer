package com.yoandypv.springaisentiment.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SentimentAnalysisService {
        private final ChatClient chatClient;
        public SentimentAnalysisService(ChatClient chatClient) {
            this.chatClient = chatClient;
        }
        public String analyzeSentiment(String text) {
            String promptTemplate = """
                Analiza el sentimiento del siguiente texto y responde solo con: Positivo, Negativo o Neutral.

                Texto: {input}
                Sentimiento:
                """;

            PromptTemplate template = new PromptTemplate(promptTemplate);
            Prompt prompt = template.create(Map.of("input", text));

            return chatClient.prompt(prompt).call().content();
        }
}

