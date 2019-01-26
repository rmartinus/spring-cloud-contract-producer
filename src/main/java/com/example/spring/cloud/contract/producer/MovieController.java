package com.example.spring.cloud.contract.producer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class MovieController {

    @PostMapping(path = "/movie")
    public ResponseEntity<String> saveMovie() {
        return ResponseEntity.created(URI.create("/movie/1")).build();
    }

    @GetMapping(path = "/movie/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String movieId) {
        return ResponseEntity.ok(new Movie(movieId, "My Movie", "Action", "2019"));
    }
}
