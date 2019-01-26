package com.example.spring.cloud.contract.producer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @PostMapping(path = "/movie")
    public ResponseEntity<String> saveMovie() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @GetMapping(path = "/movie/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String movieId) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
