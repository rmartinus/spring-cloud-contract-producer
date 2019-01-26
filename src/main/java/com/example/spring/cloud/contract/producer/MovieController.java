package com.example.spring.cloud.contract.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/movie")
    public ResponseEntity<String> saveMovie(Movie movie) {
        Long movieId = movieService.saveMovie(movie);
        return ResponseEntity.created(URI.create("/movie/" + movieId)).build();
    }

    @GetMapping(path = "/movie/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String movieId) {
        Movie movie = movieService.getMovie(movieId);
        return ResponseEntity.ok(movie);
    }
}