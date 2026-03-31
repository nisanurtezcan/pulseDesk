package com.nisa.myPulseDeskProject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class HuggingFaceService {

    private final String API_URL = "https://router.huggingface.co/v1/chat/completions";
    
    @Value("${huggingface.api.key}")
    private String apiKey;

    public String analyzeText(String comment){
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "Qwen/Qwen2.5-72B-Instruct"); 
        
        List<Map<String, String>> messages = new ArrayList<>();

         messages.add(Map.of("role", "system", "content", 
         "Analyze the user comment. If it's a bug or issue, reply with TICKET: YES. " +
         "Then please strictly provide these fields: " +
         "TITLE: (a short title), " +
         "CATEGORY: (bug/feature/billing/account/other), " +
         "PRIORITY: (low/medium/high), " +
         "SUMMARY: (a one-sentence summary of the problem)."));

     messages.add(Map.of("role", "user", "content", comment));
        
        body.put("messages", messages);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try{
            ResponseEntity<Map> response = restTemplate.postForEntity(API_URL, entity, Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
            return (String) message.get("content");
        } catch (Exception e) {
            System.out.println("AI CONNECTION ERROR (400/404): " + e.getMessage());
            
            //Default in case ai conn err
            String contentLower = comment.toLowerCase();
            if (contentLower.contains("error") || contentLower.contains("bug") || contentLower.contains("crash") || contentLower.contains("help")) {
                return "TICKET: YES\nTITLE: Auto-Detected Issue\nCATEGORY: bug\nPRIORITY: high\nSUMMARY: " + comment;
            }
            return "TICKET: NO";
        }
    }
}