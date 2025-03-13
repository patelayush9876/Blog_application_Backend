package com.blog.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Collections;
import java.util.Map;

@Service
public class PythonSummaryService {
    private static final String PYTHON_SUMMARY_URL = "http://localhost:5001/summarize";

    public String generateSummary(String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> requestBody = Collections.singletonMap("text", text);
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(PYTHON_SUMMARY_URL, HttpMethod.POST, entity, Map.class);
        return (String) response.getBody().get("summary");
    }
}
