package com.codingsaint.agentic_ai_demo;

import com.google.gson.Gson;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ChatClientService {

    private final WebClient webClient;

    @Value("${spring.ai.ollama.chat.base-url:http://localhost:11434}")
    private String baseUrl;

    //@Value("${spring.ai.ollama.chat.model:llama3.2}")
    private String model = "llama3.2";


    public ChatClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://localhost:11434")
                .defaultHeader(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON_VALUE).
                build();

    }

    public Flux<String> sendMessage(String prompt) {
        var message1 = buildRequest(prompt, true);
        Gson gson = new Gson();
        System.out.println(gson.toJson(message1));
        return webClient.post()
                .uri("/api/generate")
                .bodyValue((gson.toJson(message1)))
                .retrieve().bodyToFlux(String.class);


    }

    public String chat(String prompt) {


        OllamaApi ollamaApi = new OllamaApi.Builder().baseUrl("http://localhost:11434").build(); // Example base URL

        OllamaChatModel chatModel = OllamaChatModel.builder().ollamaApi(ollamaApi)
                // Optionally, set default options, otherwise, system defaults or properties apply
                .defaultOptions(OllamaOptions.builder()
                        .model("llama3.2") // Specify a default model
                        .temperature(0.1) // Set a default temperature
                        .build())
                .build();

        String response = ChatClient.create(chatModel)
                .prompt(prompt)
                .tools(new DateTimeTools())
                .call()
                .content();
        System.out.println(response);

    return  response;
    }


    private ChatRequest buildRequest(String message, Boolean stream) {
        return new ChatRequest(model, message, stream);
    }

    private static class ChatRequest {
        public String model;
        public String prompt;
        public Boolean stream;

        public ChatRequest(String model, String prompt, Boolean stream) {
            this.model = model;
            this.prompt = prompt;
            this.stream = stream;
        }
    }
}
