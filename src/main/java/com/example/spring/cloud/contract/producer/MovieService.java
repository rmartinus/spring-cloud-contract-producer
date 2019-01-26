package com.example.spring.cloud.contract.producer;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
    public Long saveMovie(Movie movie) {
        return 1L;
    }

    public Movie getMovie(String movieId) {
        return new Movie("1", "My Movie", "Action", "2019");
    }
}