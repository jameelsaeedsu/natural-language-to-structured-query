package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.configuration;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.llm.Transformer;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class OllamaConfig {

    @Bean
    public ChatLanguageModel ollamaChatLanguageModel() {
        return OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2")
                .responseFormat(ResponseFormat.JSON)
                .temperature(0.8)
                .timeout(Duration.ofMinutes(3))
                .build();
    }

    @Bean
    public Transformer transformer(
            ChatLanguageModel chatLanguageModel
    ) {
        return AiServices.builder(Transformer.class)
                .chatLanguageModel(chatLanguageModel)
                .build();
    }



}
