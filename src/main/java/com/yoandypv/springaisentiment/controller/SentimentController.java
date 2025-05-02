package com.yoandypv.springaisentiment.controller;

import com.yoandypv.springaisentiment.service.SentimentAnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentiment")
public class SentimentController {

    private final SentimentAnalysisService sentimentAnalysisService;

    public SentimentController(SentimentAnalysisService sentimentAnalysisService) {
        this.sentimentAnalysisService = sentimentAnalysisService;
    }

    @GetMapping()
    public String chat(@RequestParam String text) {
        return sentimentAnalysisService.analyzeSentiment(text);
    }
}
