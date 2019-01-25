package com.example.spring.cloud.contract.producer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    @GetMapping(path = "/movie/{movieId}")
    public ResponseEntity<Map<String, String>> getMovie(@PathVariable String movieId) {
        return ResponseEntity.ok(new HashMap<>() {{
            put("movieId", movieId);
            put("name", "My Movie");
            put("genre", "Action");
            put("year", "2019");
        }});
    }
}
