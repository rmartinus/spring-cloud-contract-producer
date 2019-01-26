package com.example.spring.cloud.contract.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/movie")
    public ResponseEntity<String> saveMovie(@RequestBody Movie movie) {
        Long movieId = movieService.saveMovie(movie);
        log.info("movie saved, id: {}", movieId);
        return ResponseEntity.created(URI.create("/movie/" + movieId)).build();
    }

    @GetMapping(path = "/movie/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String movieId) {
        Movie movie = movieService.getMovie(movieId);
        return ResponseEntity.ok(movie);
    }
}